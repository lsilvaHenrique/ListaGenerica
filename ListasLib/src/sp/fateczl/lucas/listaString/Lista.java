package sp.fateczl.lucas.listaString;

public class Lista {
    private No primeiro;

    public Lista() {
        this.primeiro = null;
    }

    public boolean isEmpty() {
        return this.primeiro == null;
    }

    public void addFirst(String valor) {
        No elemento = new No();
        elemento.dado = valor;
        elemento.proximo = this.primeiro;
        this.primeiro = elemento;
    }

    public void addLast(String valor) throws Exception {
        int tamanho = this.size();
        if (this.isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        No elemento = new No();
        elemento.dado = valor;
        elemento.proximo = null;
        No ultimo = this.getNo(tamanho - 1);
        ultimo.proximo = elemento;
    }

    public void add(String valor, int pos) throws Exception {
        int tamanho = this.size();
        if (pos < 0 || pos > tamanho) {
            throw new Exception("Posicao Invalida");
        }
        if (this.isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        if (pos == 0) {
            this.addFirst(valor);
        } else if (pos == tamanho) {
            this.addLast(valor);
        } else {
            No elemento = new No();
            elemento.dado = valor;
            No anterior = this.getNo(pos - 1);
            elemento.proximo = anterior.proximo;
            anterior.proximo = elemento;
        }
    }

    public int size() {
        int cont = 0;
        if (!this.isEmpty()) {
            for (No auxiliar = this.primeiro; auxiliar != null; auxiliar = auxiliar.proximo, ++cont) {
            }
        }
        return cont;
    }

    public String get(int pos) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        int tamanho = this.size();
        if (pos < 0 || pos > tamanho - 1) {
            throw new Exception("Posicao Invalida");
        }
        No auxiliar = this.primeiro;
        for (int cont = 0; cont < pos; ++cont) {
            auxiliar = auxiliar.proximo;
        }
        String valor = auxiliar.dado;
        return valor;
    }

    public void removeFirst() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        this.primeiro = this.primeiro.proximo;
    }

    public void removeLast() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        int tamanho = this.size();
        No penultimo = this.getNo(tamanho - 2);
        penultimo.proximo = null;
    }

    public void remove(int pos) throws Exception {
        int tamanho = this.size();
        if (pos < 0 || pos > tamanho - 1) {
            throw new Exception("Posicao Invalida");
        }
        if (this.isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        if (pos == 0) {
            this.removeFirst();
        } else {
            No atual = this.getNo(pos);
            No anterior = this.getNo(pos - 1);
            anterior.proximo = atual.proximo;
        }
    }

    private No getNo(final int pos) throws Exception {
        if (pos < 0) {
            throw new Exception("Posicao Invalida");
        }
        No auxiliar = this.primeiro;
        for (int cont = 0; cont < pos; ++cont) {
            auxiliar = auxiliar.proximo;
        }
        return auxiliar;
    }
    
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        No auxiliar = this.primeiro;
        while (auxiliar != null) {
            builder.append(auxiliar.dado);
            auxiliar = auxiliar.proximo;
            if (auxiliar != null) {
                builder.append(", ");
            }
        }
        builder.append(" ]");
        return builder.toString();
    }
}
