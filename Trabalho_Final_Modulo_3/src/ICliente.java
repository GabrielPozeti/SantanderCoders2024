public interface ICliente<T> {
    String getNome();
    T getDocumento();
    String getEndereco();
    long getTelefone();
}
