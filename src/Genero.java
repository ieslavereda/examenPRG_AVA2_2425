public enum Genero {
    CIENCIA_FICCION("Ciencia Ficción", TipoGenero.FICCION),
    DISTOPIA("Distopía", TipoGenero.FICCION),
    TECNICOS("Técnico",TipoGenero.NO_FICCION),
    DIVULGATIVOS("Divulgativo",TipoGenero.NO_FICCION)
    ;

    private final String tipo;
    private final Genero.TipoGenero tipoGenero;

    Genero(String tipo, TipoGenero tipoGenero) {
        this.tipo = tipo;
        this.tipoGenero = tipoGenero;
    }

    public String getTipo() {
        return tipo;
    }

    public static Genero getGenerosCadena(String cadena) throws Exception{
        String[] disgregado = cadena.split("-");
        for(Genero genero:Genero.values()){
            if(genero.getTipo().equals(disgregado[0]) && genero.tipoGenero.getTipo().equals(disgregado[1]))
                return genero;
        }
        throw new Exception("Genero no encontrado");
    }

    @Override
    public String toString(){
        return tipo + "-" + tipoGenero.getTipo();
    }

    public enum TipoGenero{
        FICCION("Ficcion"),
        NO_FICCION("No Ficción");
        private final String tipo;
        TipoGenero(String tipo){
            this.tipo=tipo;
        }
        public String getTipo(){ return tipo;}
    }

}
