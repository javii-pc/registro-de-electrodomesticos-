package electrodomesticos;

public class electrodomestico {
    private int Codigo;
    private String Nombre,Marca;
    
    public electrodomestico(int codigo, String nombre, String marca){
        this.Codigo = codigo;
        this.Nombre = nombre;
        this.Marca = marca;
        
    }

    public String getNombre() {
        return this.Nombre;
    }

    public String getMarca() {
        return this.Marca;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getCodigo() {
        return Codigo;
    }
    
    
}
