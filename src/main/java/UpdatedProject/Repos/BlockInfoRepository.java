package UpdatedProject.Repos;

import UpdatedProject.Models.BlockInfo;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author mohammad and waleed
 */
public interface BlockInfoRepository extends CrudRepository<BlockInfo, Long>{
    BlockInfo findByBlockId(String blockId);
}
