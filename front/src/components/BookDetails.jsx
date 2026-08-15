import {useEffect, useState} from 'react';
import {Link, useNavigate, useParams} from 'react-router';

import {deleteBook, getBook} from '../api/BooksApi.js';

function BookDetails() {
    const {id} = useParams();
    const navigate = useNavigate();

    const [book, setBook] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        getBook(id)
            .then(data => {
                setBook(data);
            })
            .catch(error => {
                setError(error);
            })
            .finally(() => {
                setLoading(false);
            });
    }, [id]);

    function handleDelete() {
        deleteBook(id)
            .then(() => {
                navigate('/books');
            })
            .catch(error => {
                setError(error);
            });
    }

    if (loading) {
        return <p>Cargando libro...</p>;
    }

    if (error) {
        return <p>No se ha podido cargar el libro.</p>;
    }

    if (!book) {
        return <p>Libro no encontrado.</p>;
    }

    return (
        <div className="content-container book-card">
            <h2>{book.title}</h2>
            <p><strong>Autor:</strong> {book.author}</p>
            <p><strong>Páginas:</strong> {book.pages}</p>
            <p>
                <strong>Fecha de publicación:</strong>{' '}
                {book.releaseDate}
            </p>
            <p>
                <strong>Estado:</strong>{' '}
                {book.completed ? 'Terminado ✅' : 'Pendiente ⏳'}
            </p>
            <p>
                <strong>Valoración:</strong>{' '}
                {book.rating ? `${book.rating} / 5` : 'Sin valorar'}
            </p>

            <div
                style={{
                    marginTop: '20px',
                    display: 'flex',
                    gap: '10px'
                }}
            >
                <Link className="btn-primary" to="/books">
                    Volver a la lista
                </Link>

                <Link
                    className="btn-primary"
                    to={`/books/${id}/edit`}
                >
                    Editar
                </Link>

                <button
                    style={{
                        backgroundColor: '#dc3545',
                        color: 'white',
                        border: 'none',
                        padding: '10px 15px',
                        borderRadius: '5px',
                        cursor: 'pointer',
                        fontWeight: 'bold'
                    }}
                    onClick={handleDelete}
                >
                    Eliminar
                </button>
            </div>
        </div>
    );
}

export default BookDetails;