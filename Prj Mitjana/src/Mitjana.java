
public class Mitjana {

    public static final short MAXIM = 9999;
    public static final short MINIM = 0;
    public static final short MAXVECTOR = 10;

    /* Mètode que calcula la mitjana dels 10 primers enters, entre 0 i 9.999
    (ambdós inclosos) emmagatzemats en un vector.
    Paràmetres d'entrada:
	    val = el vector de nombres enters de longitud MAXVECTOR
	    maxval = el nombre d'enters que volem analitzar
    Paràmetres de sortida dins d'un vector:
	    [0] = la mitjana dels enters vàlids
	    [1] = el nombre d'enters vàlides
	    [2] = el nombre d'enters analitzats
    Si no hi ha cap entrada vàlida retorna -1 com a mitjana*/
    public short[] calculMitjana(short[] val, short maxval) {
        short[] retorn = new short[3];//[0]mitjana [1]entrades vàlides [2]entrades analitzades
        short tentrades = 0, tvalides = 0, suma = 0;
        short i = 1;
        /*Recorrem tot el vector fins al maxval o trobar 10 valors vàlids.*/
        while ((i <= maxval) && (tvalides <= MAXVECTOR)) {
            tentrades++;
            if ((val[i] >= MINIM) && (val[i] <= MAXIM)) {
                tvalides++;
                suma += val[i];
            }
            i++;
        }
        // Si ha trobat algun valor vàlid, calcula la mitjana
        if (tvalides > 0) {
            retorn[0] = (short) (suma / tvalides);
        } else //Si no ha trobat cap valor vàlid retornsa un -1 a la primera pos.
        {
            retorn[0] = -1;
        }
        retorn[1] = tvalides;
        retorn[2] = tentrades;
        return retorn;
    }
}

