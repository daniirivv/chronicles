import {useEffect, useState} from 'react';
import {Link} from 'react-router';
import {getBooks} from '../api/BooksApi.js';

function BookList() {
    const [books, setBooks] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [searchTerm, setSearchTerm] = useState('');
    const [isSearchActive, setIsSearchActive] = useState(false);

    useEffect(() => {
        getBooks(searchTerm)
            .then(data => setBooks(data))
            .catch(error => setError(error))
            .finally(() => setLoading(false));
    }, [searchTerm]);

    function cancelSearch() {
        setIsSearchActive(false);
        setSearchTerm('');
    }

    return (
        <div>
            <div className="form-container form-container-search">
                {isSearchActive && (
                    <button className="back-btn"
                            onClick={cancelSearch}
                            title="Volver"
                    >
                        <svg
                            xmlns="http://www.w3.org/2000/svg"
                            width="24"
                            height="24"
                            viewBox="0 0 24 24"
                            fill="none"
                            stroke="currentColor"
                            strokeWidth="2.5"
                            strokeLinecap="round"
                            strokeLinejoin="round"
                        >
                            <line x1="19" y1="12" x2="5" y2="12"></line>
                            <polyline points="12 19 5 12 12 5"></polyline>
                        </svg>
                    </button>
                )}

                <input
                    className="form-input"
                    type="text"
                    placeholder="Busca libros por autor"
                    value={searchTerm}
                    onChange={(e) => setSearchTerm(e.target.value)}
                    onFocus={() => setIsSearchActive(true)}
                />
            </div>

            { !isSearchActive && (
                <Link
                    to="/books/new"
                    className="btn btn-primary"
                >
                    Crear entrada
                </Link>
            )}

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

        if (isSearchActive && searchTerm === '') {
            return null;
        }

        if (books.length === 0) {
            if (searchTerm !== '') {
                return <p>No se encontraron libros para el autor {searchTerm} :(</p>;
            } else {
                return <p>No hay libros todavía. ¡Crea el primero!</p>;
            }
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