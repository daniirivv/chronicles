function BookList({ books, showCreateForm, showDetails }) {
    return (
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
    );
}

export default BookList;