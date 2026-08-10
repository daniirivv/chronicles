import { useState, useEffect } from 'react';

import BookList from './BookList';
import BookDetails from './BookDetails';
import BookForm from './BookForm';

function Dashboard() {
    const [books, setBooks] = useState([]);
    const [currentView, setCurrentView] = useState('lista');
    const [selectedBook, setSelectedBook] = useState(null);
    const [formData, setFormData] = useState({
        title: '', author: '', pages: '', releaseDate: '', completed: false, rating: ''
    });

    // Cargar datos al iniciar
    useEffect(function () {

        function fetchBooks() {
            fetch('/books')
                .then(function(response) {
                    if (response.ok) {
                        return response.json();
                    }
                })

                .then(function(data) {
                    if (data) {
                        setBooks(data);
                    }
                })

                .catch(function(error) {
                    console.error("Error al conectar con Java: ", error);
                })
        }

        fetchBooks();

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

    function showEditForm() {
        setFormData(selectedBook);
        setCurrentView('formulario');
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
                    showList();
                })

                .catch(function(error) {
                    console.error("Error al actualizar: ", error);
                });

        } else {
            fetch(`/books`, {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(formData)
            })
                .then(function(response) {
                    if (response.ok) {
                        return response.json();
                    }
                    throw new Error("No se pudo crear el libro " + formData.title);
                })

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
        <div style={{ backgroundColor: '#f9f9f9', padding: '20px', borderRadius: '8px' }}>
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