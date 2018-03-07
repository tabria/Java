package app.waste_disposal.core;

import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.contracts.StrategyHolder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class GarbageProcessorTest {


    private GarbageProcessor garbageProcessor;
    private StrategyHolder strategyHolder;

    @Before
    public void init(){
        this.strategyHolder = mock(StrategyHolder.class);
        this.garbageProcessor = new DefaultGarbageProcessor(this.strategyHolder);

    }

    @Test
    public void getStrategyHolderToReturnStrategyHolder() {
        Assert.assertEquals("Return type is not StrtegyHolder", this.strategyHolder, this.garbageProcessor.getStrategyHolder());
    }

    @Test
    public void processWaste() {

    }

}