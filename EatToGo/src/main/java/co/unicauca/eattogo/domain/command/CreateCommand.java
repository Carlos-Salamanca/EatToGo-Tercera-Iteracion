package co.unicauca.eattogo.domain.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.unicauca.eattogo.access.LunchConsumer;
import co.unicauca.eattogo.domain.entity.LunchPart;
import co.unicauca.eattogo.domain.service.ConsumerLunchService;

/**
 * Comando de creación de una comida
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class CreateCommand extends Command{


    /**
     * Comida a crear
     */
    private LunchPart lunchPart;
    
    /**
     * Instancia al receptor
     */
    private ConsumerLunchService service;

    /**
     * Constructor parametrizado
     *
     * @param lp comida crear en la base de datos
     */
    public CreateCommand(LunchPart lp) {
        this.lunchPart = lp;
        //IFoodRepository repo = RepositoryFactory.getInstance().getRepository("default");
        LunchConsumer repo = new LunchConsumer();
        service = new ConsumerLunchService(repo);
        this.hasUndo = true;
    }

    @Override
    public void execute() {
        Logger logger = LoggerFactory.getLogger(CreateCommand.class);
        logger.info("Comando de creación ejecutado. Se creó la comida " + lunchPart.toString());
        Long idGenerated = service.create(lunchPart);
        if(idGenerated != -1)
        	lunchPart.setId(idGenerated);
    }

    @Override
    public void undo() {
        Logger logger = LoggerFactory.getLogger(CreateCommand.class);
        logger.info("Comando de creación deshecho. Se eliminó la comida " + lunchPart.toString());
        service.delete(lunchPart.getId());
    }
}
