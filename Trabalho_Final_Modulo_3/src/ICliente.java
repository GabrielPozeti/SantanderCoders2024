public interface ICliente {
    String getNome();
    String getDocumento();
    String getEndereco();
    long getTelefone();
    double calcularDescontoDias(int diasAlugados);
}