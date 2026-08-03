function BookDetails({ book, showList, showEditForm, deleteBook }) {
    return (
        <div>
            <h2>Detalles de la entrada</h2>
            <div style={{ border: '1px solid #ddd', padding: '15px', backgroundColor: 'white', borderRadius: '4px' }}>
                <h3 style={{ marginTop: 0 }}>{book.title}</h3>
                <p><strong>Autor:</strong> {book.author}</p>
                <p><strong>Páginas:</strong> {book.pages}</p>
                <p><strong>Año de publicación:</strong> {book.releaseDate}</p>
                <p><strong>Estado:</strong> {book.completed ? 'Completado' : 'Pendiente'}</p>
                <p><strong>Valoración:</strong> {book.rating ? `${book.rating} / 5` : 'Sin valorar'}</p>

                <div style={{ display: 'flex', gap: '10px', marginTop: '15px' }}>
                    <button onClick={showList} style={{ cursor: 'pointer' }}>Volver</button>
                    <button onClick={showEditForm} style={{ cursor: 'pointer' }}>Modificar</button>
                    <button onClick={() => deleteBook(book.id)} style={{ cursor: 'pointer', color: 'red' }}>
                        Eliminar
                    </button>
                </div>
            </div>
        </div>
    );
}

export default BookDetails;