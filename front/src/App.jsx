import {Navigate, Route, Routes} from 'react-router';

import BookList from './components/BookList.jsx';
import BookDetails from './components/BookDetails.jsx';
import BookForm from './components/BookForm.jsx';

function App() {
    return (
        <div
            style={{
                maxWidth: '800px',
                margin: '0 auto',
                padding: '20px',
                fontFamily: 'sans-serif'
            }}
        >
            <header style={{textAlign: 'center', marginBottom: '30px'}}>
                <h1 className="brand-title">Chronicles</h1>
            </header>

            <main>
                <Routes>
                    <Route
                        path="/"
                        element={<Navigate to="/books" replace />}
                    />

                    <Route
                        path="/books"
                        element={<BookList />}
                    />

                    <Route
                        path="/books/new"
                        element={<BookForm />}
                    />

                    <Route
                        path="/books/:id"
                        element={<BookDetails />}
                    />

                    <Route
                        path="/books/:id/edit"
                        element={<BookForm />}
                    />
                </Routes>
            </main>
        </div>
    );
}

export default App;