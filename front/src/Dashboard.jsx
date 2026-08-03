import { useState } from 'react';

import BookList from './BookList';
import BookDetails from './BookDetails';
import BookForm from './BookForm';

function Dashboard() {
    const [books, setBooks] = useState([
        { id: 1, title: 'El Imperio Final', author: 'Brandon Sanderson', pages: 688, releaseDate: 1968, completed: false, rating: null },
        { id: 2, title: 'Hábitos Atómicos', author: 'James Clear', pages: 349, releaseDate: 2016, completed: true, rating: 3 }
    ]);
    const [currentView, setCurrentView] = useState('lista');
    const [selectedBook, setSelectedBook] = useState(null);
    const [formData, setFormData] = useState({
        title: '', author: '', pages: '', releaseDate: '', completed: false, rating: ''
    });


    // --- FUNCIONES DE NAVEGACIÓN ---

    const showDetails = (book) => {
        setSelectedBook(book);
        setCurrentView('detalles');
    };
    const showList = () => {
        setSelectedBook(null);
        setCurrentView('lista');
    };
    const showCreateForm = () => {
        setFormData({ title: '', author: '', pages: '', releaseDate: '', completed: false, rating: '' });
        setCurrentView('formulario');
    };
    const showEditForm = () => {
        setFormData(selectedBook);
        setCurrentView('formulario');
    };


    // --- FUNCIONES DE ACCIÓN ---

    const deleteBook = (idToRemove) => {
        const updatedBooks = books.filter((book) => book.id !== idToRemove);
        setBooks(updatedBooks);
        showList();
    };
    const saveBook = () => {
        if (formData.id) {
            const updatedBooks = books.map((book) => book.id === formData.id ? formData : book);
            setBooks(updatedBooks);
        } else {
            const newBook = { ...formData, id: Date.now() };
            setBooks([...books, newBook]);
        }
        showList();
    };


    // --- RENDERIZADO VISUAL ---

    return (
        <div style={{ backgroundColor: '#f9f9f9', padding: '20px', borderRadius: '8px' }}>

            {/* Si la vista es lista, llamamos al componente BookList y le pasamos lo que necesita */}
            {currentView === 'lista' && (
                <BookList
                    books={books}
                    showCreateForm={showCreateForm}
                    showDetails={showDetails}
                />
            )}

            {currentView === 'detalles' && selectedBook && (
                <BookDetails
                    book={selectedBook}
                    showList={showList}
                    showEditForm={showEditForm}
                    deleteBook={deleteBook}
                />
            )}

            {currentView === 'formulario' && (
                <BookForm
                    formData={formData}
                    setFormData={setFormData}
                    showList={showList}
                    saveBook={saveBook}
                />
            )}

        </div>
    );
}

export default Dashboard;