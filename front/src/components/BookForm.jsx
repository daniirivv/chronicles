import {useEffect, useState} from 'react';
import {Link, useNavigate, useParams} from 'react-router';

import {createBook, getBook, updateBook} from '../api/BooksApi.js'

function BookForm() {
    const {id} = useParams();
    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        title: '',
        author: '',
        pages: '',
        releaseDate: '',
        completed: false,
        rating: ''
    });

    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    useEffect(() => {
        if (!id) {
            return;
        }

        setLoading(true);

        getBook(id)
            .then(book => {
                setFormData({
                    id: book.id,
                    title: book.title ?? '',
                    author: book.author ?? '',
                    pages: book.pages ?? '',
                    releaseDate: book.releaseDate ?? '',
                    completed: book.completed ?? false,
                    rating: book.rating ?? ''
                });
            })
            .catch(error => {
                setError(error);
            })
            .finally(() => {
                setLoading(false);
            });
    }, [id]);

    function handleSave() {
        const saveOperation = id
            ? updateBook(id, formData)
            : createBook(formData);

        saveOperation
            .then(() => {
                navigate(id ? `/books/${id}` : '/books');
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

    return (
        <div>
            <h2>{id ? 'Modificar Entrada' : 'Crear Nueva Entrada'}</h2>

            <div
                className="book-card"
                style={{
                    display: 'flex',
                    flexDirection: 'column',
                    gap: '10px'
                }}
            >
                <input
                    placeholder="Título del libro"
                    value={formData.title}
                    onChange={(e) =>
                        setFormData({
                            ...formData,
                            title: e.target.value
                        })
                    }
                    style={{padding: '8px'}}
                />

                <input
                    placeholder="Autor"
                    value={formData.author}
                    onChange={(e) =>
                        setFormData({
                            ...formData,
                            author: e.target.value
                        })
                    }
                    style={{padding: '8px'}}
                />

                <input
                    placeholder="Número de páginas"
                    type="number"
                    value={formData.pages}
                    onChange={(e) =>
                        setFormData({
                            ...formData,
                            pages: e.target.value
                        })
                    }
                    style={{padding: '8px'}}
                />

                <input
                    placeholder="Año de lanzamiento"
                    type="number"
                    value={formData.releaseDate}
                    onChange={(e) =>
                        setFormData({
                            ...formData,
                            releaseDate: e.target.value
                        })
                    }
                    style={{padding: '8px'}}
                />

                <label
                    style={{
                        display: 'flex',
                        alignItems: 'center',
                        gap: '10px',
                        padding: '8px'
                    }}
                >
                    <input
                        type="checkbox"
                        checked={formData.completed}
                        onChange={(e) =>
                            setFormData({
                                ...formData,
                                completed: e.target.checked,
                                rating: e.target.checked
                                    ? formData.rating
                                    : ''
                            })
                        }
                    />
                    ¿Terminado?
                </label>

                {formData.completed && (
                    <input
                        placeholder="Valoración"
                        type="number"
                        value={formData.rating}
                        onChange={(e) =>
                            setFormData({
                                ...formData,
                                rating: e.target.value
                            })
                        }
                        style={{padding: '8px'}}
                    />
                )}

                <div
                    style={{
                        display: 'flex',
                        gap: '10px',
                        marginTop: '10px'
                    }}
                >
                    <Link
                        to={id ? `/books/${id}` : '/books'}
                        style={{
                            cursor: 'pointer',
                            padding: '10px 15px',
                            border: '1px solid #ddd',
                            borderRadius: '5px',
                            backgroundColor: 'transparent'
                        }}
                    >
                        Cancelar
                    </Link>

                    <button
                        className="btn-primary"
                        onClick={handleSave}
                    >
                        Guardar
                    </button>
                </div>
            </div>
        </div>
    );
}

export default BookForm;