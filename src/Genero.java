public enum Genero {
    CIENCIA_FICCION("Ciencia Ficcion", TipoGenero.FICCION),
    DISTOPIA("Distopia", TipoGenero.FICCION),
    TECNICOS("Tecnico",TipoGenero.NO_FICCION),
    DIVULGATIVOS("Divulgativo",TipoGenero.NO_FICCION)
    ;

    private final String genero;
    private final Genero.TipoGenero tipoGenero;

    Genero(String tipo, TipoGenero tipoGenero) {
        this.genero = tipo;
        this.tipoGenero = tipoGenero;
    }

    public String getGenero() {
        return genero;
    }

    public TipoGenero getTipoGenero() {
        return tipoGenero;
    }

    public static Genero getGenerosCadena(String cadena) throws Exception{
        String[] disgregado = cadena.split("-");
        for(Genero genero:Genero.values()){
            if(genero.getGenero().equals(disgregado[0]) && genero.tipoGenero.getTipo().equals(disgregado[1]))
                return genero;
        }
        throw new Exception("Genero no encontrado");
    }

    @Override
    public String toString(){
        return genero + "-" + tipoGenero.getTipo();
    }

    public enum TipoGenero{
        FICCION("Ficcion"),
        NO_FICCION("No Ficcion");
        private final String tipo;
        TipoGenero(String tipo){
            this.tipo=tipo;
        }
        public String getTipo(){ return tipo;}
    }

}
