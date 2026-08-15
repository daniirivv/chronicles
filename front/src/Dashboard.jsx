import './Dashboard.css';
import { useState, useEffect } from 'react';

import BookList from './BookList';
import BookDetails from './BookDetails';
import BookForm from './BookForm';
import {createBook, getBooks} from "./api/BooksApi.js";

function Dashboard() {
    const [books, setBooks] = useState([]);
    const [currentView, setCurrentView] = useState('lista');
    const [selectedBook, setSelectedBook] = useState(null);
    const [formData, setFormData] = useState({
        title: '',
        author: '',
        pages: '',
        releaseDate: '',
        completed: false,
        rating: ''
    });

    useEffect(() => {
        getBooks()
            .then(data => setBooks(data))
            .catch(error => console.error("Error al cargar libros: ", error))
    }, []);


    // --- FUNCIONES DE NAVEGACIÓN ---

    function showDetails(book) {
        setSelectedBook(book);
        setCurrentView('detalles');
    }

    function showList() {
        setSelectedBook(null);
        setCurrentView('lista');
    }

    function showCreateForm() {
        setFormData({title: '', author: '', pages: '', releaseDate: '', completed: false, rating: ''});
        setCurrentView('formulario');
    }

    function showEditForm(bookToEdit) {

        if (bookToEdit) {
            setSelectedBook(bookToEdit);
            setFormData({
                id: bookToEdit.id,
                title: bookToEdit.title || '',
                author: bookToEdit.author || '',
                pages: bookToEdit.pages || '',
                releaseDate: bookToEdit.releaseDate || '',
                completed: bookToEdit.completed || false,
                rating: bookToEdit.rating || ''
            });
            setCurrentView('formulario');
        }
    }


    // --- FUNCIONES DE ACCIÓN ---

    function deleteBook(idToRemove) {
        fetch(`/books/${idToRemove}`, { method: 'DELETE' })
            .then(function(response) {
                if (response.ok) {
                    const updatedBooks = books.filter(function(book) {
                        return book.id !== idToRemove;
                    });
                    setBooks(updatedBooks);
                    showList();
                }
            })

            .catch(function(error) {
                console.error("Error al eliminar: ", error);
            });
    }

    function saveBook() {
        const isUpdating = selectedBook !== null;

        if (isUpdating) {
            fetch(`/books/${selectedBook.id}`, {
                method: 'PATCH',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(formData)
            })
                .then(function(response) {
                    if (response.ok) {
                        return response.json();
                    }
                    throw new Error("No se pudo actualizar el libro " + formData.title);
                })

                .then(function(updatedBook) {
                    const updatedBooks = books.map(function(book) {
                        if (book.id === updatedBook.id) {
                            return updatedBook;
                        } else {
                            return book;
                        }
                    });
                    setBooks(updatedBooks);
                    setSelectedBook(updatedBook);
                    showList();
                })

                .catch(function(error) {
                    console.error("Error al actualizar: ", error);
                });

        } else {
            createBook(formData)
                .then(function(newBook) {
                    setBooks([...books, newBook]);
                    showList();
                })

                .catch(function(error) {
                    console.error("Error al crear: ", error);
                });
        }
    }


    // --- RENDERIZADO VISUAL ---

    return (
        <div className='dashboard-container'>
            {currentView === 'lista' && (
                <BookList books={books} showCreateForm={showCreateForm} showDetails={showDetails}/>
            )}
            {currentView === 'detalles' && selectedBook && (
                <BookDetails book={selectedBook} showList={showList} showEditForm={showEditForm} deleteBook={deleteBook}/>
            )}
            {currentView === 'formulario' && (
                <BookForm formData={formData} setFormData={setFormData} showList={showList} saveBook={saveBook}/>
            )}
        </div>
    );
}

export default Dashboard;