import Dashboard from './Dashboard';

function App() {
  return (
      <div style={{ maxWidth: '800px', margin: '0 auto', padding: '20px', fontFamily: 'sans-serif' }}>
        <header style={{ textAlign: 'center', marginBottom: '30px' }}>
          <h1>Chronicles</h1>
        </header>

        <main>
          { /* Aquí se carga el componente del dashboard más tarde */}
            <Dashboard />
        </main>
      </div>
  );
}

export default App;