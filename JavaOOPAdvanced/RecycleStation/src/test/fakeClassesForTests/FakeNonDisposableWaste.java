package test.fakeClassesForTests;

import app.waste_disposal.contracts.Waste;

@FakeNonDisposable
public class FakeNonDisposableWaste implements Waste {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getVolumePerKg() {
        return 0;
    }

    @Override
    public double getWeight() {
        return 0;
    }
}
