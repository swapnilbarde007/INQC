package com.INQC.Repository;

import com.INQC.Entity.Commands.AIRCommands;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AIRCommandRepo extends MongoRepository<AIRCommands,String> {
//public interface AIRCommandRepo extends JpaRepository<AIRCommands,Long> {

    boolean existsBy();


}
