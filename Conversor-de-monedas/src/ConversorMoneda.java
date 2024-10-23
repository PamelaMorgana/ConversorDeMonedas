public class ConversorMoneda {
    private static ConsultaMoneda consulta;

    public ConversorMoneda() {
        this.consulta = new ConsultaMoneda();
    }

    public static double convertir(String monedaBase, String monedaCambio, double monto) {
        Moneda moneda = consulta.buscaMoneda(monedaBase, monedaCambio);
        double tasaConversion = moneda.conversion_rate();
        return monto * tasaConversion;
    }
}
