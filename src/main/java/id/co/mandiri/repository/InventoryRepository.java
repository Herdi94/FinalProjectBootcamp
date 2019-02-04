package id.co.mandiri.repository;

import id.co.mandiri.entity.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, String> {
}
