package database;

import Utility.Constants;
import contracts.IModelable;
import contracts.IRepository;
import exeptions.DuplicateModelException;
import exeptions.NonExistantModelException;

import java.util.HashMap;
import java.util.Map;

public class Repository<T extends IModelable> implements IRepository {
    private Map<String, IModelable> itemsByModel;

    public Repository()
    {
        this.itemsByModel = new HashMap<>();
    }

    @Override
    public void Add(IModelable item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }
        this.itemsByModel.put(item.getModel(), item);
    }

    @Override
    public IModelable GetItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model)) {
            throw new NonExistantModelException(Constants.NON_EXISTENT_MODEL_MESSAGE);
        }
        return this.itemsByModel.get(model);
    }

}
