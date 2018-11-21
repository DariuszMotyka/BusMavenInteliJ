package Bus;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dfs {
    // tablica krawedzi ktora jest
    // przechowuje wierzcholki z ktorych mozna sie dostac do biezacego
    // okreslonego indeksem tablicy
    private int[] edgeTo;
    // tablica odwiedzonych wierzcholkow
    private boolean[] marked;
    // wierzcholek zrodlowy, z ktorego rozpoczynamy przeszukiwanie
    private final int source;

    public Dfs(CityMap graph, int source) {
        this.source = source;
        edgeTo = new int[graph.getNumberOfBusStop()];
        marked = new boolean[graph.getNumberOfBusStop()];
        dfs(graph, source);
    }

    /**
     * @param vertex indeks wierzcholka dla ktorego ma byc sprawdzenie istnienia
     *               sciezki
     * @return true jesli istnieje sciezka z wierzcholka zrodlowego danego w
     * konstruktorze do wierzcholka {@code vertex}
     */
    public boolean hasPathTo(int vertex) {
        return marked[vertex];
    }

    /**
     * @param vertex docelowy wierzcholek
     * @return stos wierzcholkow prowadzacych ze zrodal {@code source} do celu
     * {@code vertex} jesli sciezka nie istnieje zwracana jest pusta
     * kolekcja
     */
    public Iterable<Integer> getPathTo(int vertex) {
        Deque<Integer> path = new ArrayDeque<Integer>();
    // jesli nie istnieje sciezka zwroc pusta sciezke
        if (!hasPathTo(vertex)) {
            return path;
        }
        // dopoki istnieje wierzcholek dodawaj go do stosu
        for (int w = vertex; w != source; w = edgeTo[w]) {
            path.push(w);
        }
        // dodaj na koniec krawedz zrodlowa
        path.push(source);
        return path;
    }

    private void dfs(CityMap graph, int vertex) {
        // oznaczamy wierzcholek jako odwiedzony
        marked[vertex] = true;
        // 	dla kazdego sasiedniego wierzcholka jesli nie jest oznaczony
        // 	wywolujemy rekurencyjnie metode dfs, ktora odwiedzi wierzchoki i
        // zapisze trase
        for (int i = 0; i < graph.getConnectionList(vertex).size(); i++)
            //for (int w : graph.getConnectionList(vertex)) {
            //if (!marked[w]) {
            if (!marked[i]) {
                //edgeTo[w] = vertex;
                edgeTo[i] = vertex;
                //	dfs(graph, w);
                dfs(graph, i);
            }
    }
}
