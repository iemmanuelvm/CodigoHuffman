public class OrdenarCaracterConPx implements Comparable<OrdenarCaracterConPx> 
{
    public double Px;
    public String Cadena;
    public int Veces;
    //Esta referencia se usa para pasar la referencia al objeto actual como un parámetro para otros métodos. 
    public OrdenarCaracterConPx(int P) 
    {
        Veces = P;
    }

    //Retorna si se requiere el Valor ingresado
    public double getPx() 
    {
        return Px;
    }

    //Retorna si se requiere el Valor ingresado
    public void setPx(double Px) 
    {
        this.Px = Px;
    }

    //Retorna si se requiere el Valor ingresado
    public String getCadena() 
    {
        return Cadena;
    }

    //Retorna si se requiere el Valor ingresado
    public void setCadena(String Cadena) 
    {
        this.Cadena = Cadena;
    }

    //Retorna si se requiere el Valor ingresado
    public int getVeces() 
    {
        return Veces;
    }

    //Retorna si se requiere el Valor ingresado
    public void setVeces(int Veces) 
    {
        this.Veces = Veces;
    }

    //Metodo predefinido en java para ordenar la cola de prioridad de mayor a menor (Descendentemente)
    public int compareTo(OrdenarCaracterConPx tree) {
        return Veces - tree.Veces;
    }
}