public class Estudiante {
    private String nombre;
    private int edad;
    private boolean matriculado;
    private double media;

    public Estudiante() {}
    public Estudiante (String nombre, int edad, double media, boolean matriculado) {
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setMedia(media);
        this.setMatriculado(matriculado);
    }

    public void setNombre(String nombre) {
        if (nombre.isEmpty())
            throw new IllegalArgumentException("Debes introducir un nombre válido.");
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        if (edad < 0 || edad > 100)
            throw new IllegalArgumentException("La edad debe ser positiva y econtrarse dentro de los parametros reales.");
        this.edad = edad;
    }

    public void setMedia(double nota) {
        if (nota < 0 || nota >= 10)
            throw new IllegalArgumentException("La nota no puede ser negativa o pasar de 10.");
        this.media = nota;
    }

    public void setMatriculado(boolean matriculado) {
        this.matriculado = matriculado;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public double getMedia() {
        return this.media;
    }

    public boolean getMatriculado() {
        return this.matriculado;
    }
}
