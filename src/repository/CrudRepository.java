package repository;

public interface CrudRepository<T> {

    void Salvar(T entity);

    void Listar();

    void Deletar(String nome);
}
