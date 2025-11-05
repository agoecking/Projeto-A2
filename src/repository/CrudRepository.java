package repository;

//Interface de "CRUD" a ser utilizada pelos repositórios, contém as classes de salvar, listar e deletar.
public interface CrudRepository<T> {

    void Salvar(T entity);

    void Listar();

    void Deletar(String nome);
}
