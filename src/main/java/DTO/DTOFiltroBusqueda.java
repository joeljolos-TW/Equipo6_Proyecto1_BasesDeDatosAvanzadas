package DTO;

/**
 * Clase DTO generico para el filtrado de filas en una query, ademas de ayudar con la paginacion
 * de busqueda
 * @author joel_
 */
public class DTOFiltroBusqueda{
    private int limit;
    private int offset;
    private String filtro;

    public DTOFiltroBusqueda() {
    }

    public DTOFiltroBusqueda(int limit, int offset, String filtro) {
        this.limit = limit;
        this.offset = offset;
        this.filtro = filtro;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
    
    
}