package sp.fateczl.lucas.listaInt;

public class Lista {
	No primeiro;
    
    public Lista() {
        this.primeiro = null;
    }
    
    public boolean isEmpty() {
        return this.primeiro == null;
    }
    
    public void addFirst(final int valor) {
        final No elemento = new No();
        elemento.dado = valor;
        elemento.proximo = this.primeiro;
        this.primeiro = elemento;
    }
    
    public void addLast(final int valor) throws Exception {
        final int tamanho = this.size();
        if (this.isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        final No elemento = new No();
        elemento.dado = valor;
        elemento.proximo = null;
        final No ultimo = this.getNo(tamanho - 1);
        ultimo.proximo = elemento;
    }
    
    public void add(final int valor, final int pos) throws Exception {
        final int tamanho = this.size();
        if (pos < 0 || pos > tamanho) {
            throw new Exception("Posicao Invalida");
        }
        if (this.isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        if (pos == 0) {
            this.addFirst(valor);
        }
        else if (pos == tamanho) {
            this.addLast(valor);
        }
        else {
            final No elemento = new No();
            elemento.dado = valor;
            final No anterior = this.getNo(pos - 1);
            elemento.proximo = anterior.proximo;
            anterior.proximo = elemento;
        }
    }
    
    public int size() {
        int cont = 0;
        if (!this.isEmpty()) {
            for (No auxiliar = this.primeiro; auxiliar != null; auxiliar = auxiliar.proximo, ++cont) {}
        }
        return cont;
    }
    
    public int get(final int pos) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        final int tamanho = this.size();
        if (pos < 0 || pos > tamanho - 1) {
            throw new Exception("Posicao Invalida");
        }
        No auxiliar = this.primeiro;
        for (int cont = 0; cont < pos; ++cont) {
            auxiliar = auxiliar.proximo;
        }
        final int valor = auxiliar.dado;
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
        final int tamanho = this.size();
        final No penultimo = this.getNo(tamanho - 2);
        penultimo.proximo = null;
    }
    
    public void remove(final int pos) throws Exception {
        final int tamanho = this.size();
        if (pos < 0 || pos > tamanho - 1) {
            throw new Exception("Posicao Invalida");
        }
        if (this.isEmpty()) {
            throw new Exception("Lista Vazia");
        }
        if (pos == 0) {
            this.removeFirst();
        }
        else {
            final No atual = this.getNo(pos);
            final No anterior = this.getNo(pos - 1);
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
        final StringBuffer buffer = new StringBuffer();
        try {
            for (int tamanho = this.size(), i = 0; i < tamanho; ++i) {
                buffer.append("[ ");
                buffer.append(this.get(i));
                buffer.append(" ]");
                buffer.append("[]->");
                if (i == tamanho - 1) {
                    buffer.append("NULL");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}

