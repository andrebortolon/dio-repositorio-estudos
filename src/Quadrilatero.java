public class Quadrilatero {

    public static float retorneArea(float lado) {
        return lado * lado;
    }

    public static float retorneArea(float base, float latEsquerda) {
        return base * latEsquerda;
    }

    /*
    Este método pressupõe que a base e o topo do quadrilátero são paralelas e que as laterais são diagonais e
    cujo ângulo é o mesmo em ambas. Como o objetivo do exercício é sobre sobrecarga de métodos, não há a
    necessidade de refinamento das possibilidades de cálculo.
     */
    public static float retorneArea(float base, float topo, float latEsquerda, float latDireita) {
        float altura;
        float compMenor;
        float compMaior;
        if (base > topo) {
            compMenor = (base - topo) / 2;
            compMaior = topo;
        } else {
            compMenor = (topo - base) / 2;
            compMaior = base;
        }
        altura = calculeAltura(compMenor, latEsquerda);
        return Triangulo.area(compMenor, altura) * 2 + retorneArea(compMaior, altura);
    }

    private static float calculeAltura(float v, float latDireita) {
        return (float) Math.sqrt(Math.pow(latDireita,2) - Math.pow(v,2));
    }

}
