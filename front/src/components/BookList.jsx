import {useEffect, useState} from 'react';
import {Link} from 'react-router';
import {getBooks} from '../api/BooksApi.js';

function BookList() {
    const [books, setBooks] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        getBooks()
            .then(data => setBooks(data))
            .catch(error => setError(error))
            .finally(() => setLoading(false));
    }, []);

    return (
        <div>
            <Link
                to="/books/new"
                className="btn btn-primary"
            >
                Crear entrada
            </Link>

            {renderContent()}
        </div>
    );

    function renderContent() {
        if (loading) {
            return <p>Cargando libros...</p>;
        }

        if (error) {
            return <p>No se han podido cargar los libros.</p>;
        }

        if (books.length === 0) {
            return <p>No hay libros todavía. ¡Crea el primero!</p>;
        }

        return books.map(book => (
            <div key={book.id} className="book-card">
                <h3>{book.title}</h3>
                <p>Autor: {book.author}</p>

                <Link to={`/books/${book.id}`}>
                    Ver detalles
                </Link>
            </div>
        ));
    }
}

export default BookList;