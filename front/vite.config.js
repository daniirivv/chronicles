import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      // Cualquier petición que empiece por '/books', se le envía al servidor de Spring Boot
      'books': {
        target: 'http://localhost:8080',
        changeOrigin: true,
      }
    }
  }
})
