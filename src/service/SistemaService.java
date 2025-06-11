package service;

public class SistemaService {

    private PokemonService pokemonService;
    private TreinadorService treinadorService;
    private BatalhaService batalhaService;

    public SistemaService() {
        this.pokemonService = new PokemonService();
        this.treinadorService = new TreinadorService();
        this.batalhaService = new BatalhaService();
    }

    public PokemonService getPokemonService() {
        return pokemonService;
    }

    public TreinadorService getTreinadorService() {
        return treinadorService;
    }

    public BatalhaService getBatalhaService() {
        return batalhaService;
    }

    public void salvarTudo() {
        pokemonService.salvarPokemons();
        treinadorService.salvarTreinadores();
        batalhaService.salvarBatalhas();
    }
    
    public void carregarTudo() {
        pokemonService.carregarPokemons();
        treinadorService.carregarTreinadores();
        batalhaService.carregarBatalhas();
    }
}
