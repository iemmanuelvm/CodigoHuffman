//Se hereda de la clase OrdenarCaracterConPx para saber que numeros dieron origen al nuevo valor
public class ValorAnterior extends OrdenarCaracterConPx 
{
    OrdenarCaracterConPx valorAIzquierda, valorADerecha; // valores generados nuevos
 
    public ValorAnterior(OrdenarCaracterConPx NodoIzquierdo, OrdenarCaracterConPx NodoDerecho) 
    {
        super(NodoIzquierdo.Veces + NodoDerecho.Veces);
        valorAIzquierda = NodoIzquierdo;
        valorADerecha = NodoDerecho;
    }
}