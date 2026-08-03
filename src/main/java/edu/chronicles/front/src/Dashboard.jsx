import { useState } from 'react';

function Dashboard() {

    // Entradas de libros de prueba
    const [books, setBooks] = useState([
        { id: 1, title: 'El Imperio Final', author: 'Brandon Sanderson', pages: 688, releaseDate: 1968, completed: false, rating: null },
        { id: 2, title: 'Hábitos Atómicos', author: 'James Clear', pages: 349, releaseDate: 2016, completed: true, rating: 3 }
    ]);

    // Estado para controlar qué vista mostrar
    const [currentView, setCurrentView] = useState('lista');

    // Estado para guardar el libro que el usuario ha seleccionado
    const [selectedBook, setSelectedBook] = useState(null);

    // NUEVO: Estado para recordar lo que el usuario escribe en el formulario
    const [formData, setFormData] = useState({
        title: '', author: '', pages: '', releaseDate: '', completed: false, rating: ''
    });

    /*
     FUNCIONES DE NAVEGACIÓN
    */

    // Mostrar la vista de detalles de un libro
    const showDetails = (book) => {
        setSelectedBook(book);
        setCurrentView('detalles');
    };

    // Regresar a la lista principal
    const showList = () => {
        setSelectedBook(null);
        setCurrentView('lista');
    };

    // Mostrar el formulario de creación
    const showCreateForm = () => {
        setFormData({ title: '', author: '', pages: '', releaseDate: '', completed: false, rating: '' });
        setCurrentView('formulario');
    };

    // Mostrar el formulario de edición
    const showEditForm = () => {
        setFormData(selectedBook);
        setCurrentView('formulario');
    };

    /*
     FUNCIONES DE ACCIÓN
    */

    // Eliminar un libro
    const deleteBook = (idToRemove) => {
        const updatedBooks = books.filter((book) => book.id !== idToRemove);
        setBooks(updatedBooks);
        showList();
    };

    // Guardar un libro
    const saveBook = () => {
        if (formData.id) {
            // Si tiene ID, es una modificación
            const updatedBooks = books.map((book) =>
                book.id === formData.id ? formData : book
            );
            setBooks(updatedBooks);
        } else {
            // Si no tiene ID, es un libro nuevo
            const newBook = { ...formData, id: Date.now() }; // Le damos un ID temporal
            setBooks([...books, newBook]);
        }
        showList();
    };

    /*
     RENDERIZADO VISUAL
    */

    return (
        <div style={{ backgroundColor: '#f9f9f9', padding: '20px', borderRadius: '8px' }}>

            {/* VISTA 1: LISTA DE ENTRADAS */}
            {currentView === 'lista' && (
                <div>
                    <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: '15px' }}>
                        <h2>Mis Entradas</h2>
                        <button onClick={showCreateForm} style={{ padding: '8px 12px', cursor: 'pointer' }}>
                            Crear Entrada
                        </button>
                    </div>

                    <div style={{ display: 'flex', flexDirection: 'column', gap: '10px' }}>
                        {books.map((book) => (
                            <div key={book.id} style={{ border: '1px solid #ddd', padding: '10px', backgroundColor: 'white', borderRadius: '4px' }}>
                                <h3 style={{ margin: '0 0 5px 0' }}>{book.title}</h3>
                                <p style={{ margin: '0 0 10px 0' }}>Autor: {book.author}</p>
                                <p style={{ margin: '0 0 10px 0', fontSize: '0.9em' }}>
                                    Estado: {book.completed ? '✅' : '⏳'}
                                </p>
                                <button onClick={() => showDetails(book)} style={{ cursor: 'pointer' }}>
                                    Ver Detalles
                                </button>
                            </div>
                        ))}
                    </div>
                </div>
            )}

            {/* VISTA 2: DETALLES DEL LIBRO */}
            {currentView === 'detalles' && selectedBook && (
                <div>
                    <h2>Detalles de la entrada</h2>
                    <div style={{ border: '1px solid #ddd', padding: '15px', backgroundColor: 'white', borderRadius: '4px' }}>
                        <h3 style={{ marginTop: 0 }}>{selectedBook.title}</h3>
                        <p><strong>Autor:</strong> {selectedBook.author}</p>
                        <p><strong>Páginas:</strong> {selectedBook.pages}</p>
                        <p><strong>Año de publicación:</strong> {selectedBook.releaseDate}</p>
                        <p><strong>Estado:</strong> {selectedBook.completed ? 'Completado' : 'Pendiente'}</p>
                        <p><strong>Valoración:</strong> {selectedBook.rating ? `${selectedBook.rating} / 5` : 'Sin valorar'}</p>

                        <div style={{ display: 'flex', gap: '10px', marginTop: '15px' }}>
                            <button onClick={showList} style={{ cursor: 'pointer' }}>Volver</button>
                            <button onClick={showEditForm} style={{ cursor: 'pointer' }}>Modificar</button>
                            <button onClick={() => deleteBook(selectedBook.id)} style={{ cursor: 'pointer', color: 'red' }}>
                                Eliminar
                            </button>
                        </div>
                    </div>
                </div>
            )}

            {/* VISTA 3: FORMULARIO DE CREACIÓN / EDICIÓN */}
            {currentView === 'formulario' && (
                <div>
                    {/* MODIFICADO: El título cambia según si estamos creando o modificando */}
                    <h2>{formData.id ? 'Modificar Entrada' : 'Crear Nueva Entrada'}</h2>
                    <div style={{ display: 'flex', flexDirection: 'column', gap: '10px', backgroundColor: 'white', padding: '15px', border: '1px solid #ddd', borderRadius: '4px' }}>

                        <input
                            placeholder="Título del libro"
                            value={formData.title}
                            onChange={(e) => setFormData({ ...formData, title: e.target.value })}
                            style={{ padding: '8px' }}
                        />
                        <input
                            placeholder="Autor"
                            value={formData.author}
                            onChange={(e) => setFormData({ ...formData, author: e.target.value })}
                            style={{ padding: '8px' }}
                        />
                        <input
                            placeholder="Número de páginas"
                            type="number"
                            value={formData.pages}
                            onChange={(e) => setFormData({ ...formData, pages: e.target.value })}
                            style={{ padding: '8px' }}
                        />
                        <input
                            placeholder="Año de lanzamiento"
                            type="number"
                            value={formData.releaseDate}
                            onChange={(e) => setFormData({ ...formData, releaseDate: e.target.value })}
                            style={{ padding: '8px' }}
                        />

                        <label style={{ display: 'flex', alignItems: 'center', gap: '10px', padding: '8px' }}>
                            <input
                                type="checkbox"
                                checked={formData.completed}
                                onChange={(e) => setFormData({ ...formData, completed: e.target.checked })}
                            />
                            ¿Terminado?
                        </label>

                        <input
                            placeholder="Valoración"
                            type="number"
                            value={formData.rating}
                            onChange={(e) => setFormData({ ...formData, rating: e.target.value })}
                            style={{ padding: '8px' }}
                        />

                        <div style={{ display: 'flex', gap: '10px', marginTop: '10px' }}>
                            <button onClick={showList} style={{ cursor: 'pointer' }}>Cancelar</button>
                            <button onClick={saveBook} style={{ cursor: 'pointer', backgroundColor: '#4CAF50', color: 'white', border: 'none', padding: '8px 12px' }}>
                                Guardar
                            </button>
                        </div>
                    </div>
                </div>
            )}

        </div>
    );
}

export default Dashboard;