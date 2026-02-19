// ============================================================
// MODELO (Interfaz TypeScript)
// Define la ESTRUCTURA que deben tener todos los objetos Libro.
// Una interfaz no genera código JavaScript, solo es un "contrato"
// que TypeScript usa para validar que los objetos tienen las
// propiedades correctas con los tipos correctos.
// ============================================================

export interface Libro {
  // _id es OPCIONAL (?) porque al CREAR un libro aún no tiene ID
  // El servicio se lo asignará automáticamente al guardarlo
  _id?: string;

  // Título del libro — debe ser siempre un string
  titulo: string;

  // Autor del libro — debe ser siempre un string
  autor: string;

  // Género literario — usamos un tipo union (|) para limitar los valores posibles
  // Concepto de TypeScript visto en U3.2: Tipo literal + Tipo union
  genero: 'Ficción' | 'No ficción' | 'Ciencia ficción' | 'Fantasía' | 'Terror' | 'Historia' | 'Otro';

  // Año de publicación — number para poder hacer comparaciones numéricas
  anio: number;

  // Descripción del libro — string de texto libre
  descripcion: string;
}
