package it.poli.entity.generator;

import java.util.EnumSet;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;

public class RandomStringGenerator implements BeforeExecutionGenerator {

  private static final long serialVersionUID = -4686540893274932859L;

  @Override
  public EnumSet<EventType> getEventTypes() {
    return EnumSet.of(EventType.INSERT);
  }

  @Override
  public Object generate(
      SharedSessionContractImplementor session,
      Object owner,
      Object currentValue,
      EventType eventType) {
    return session.createNativeQuery("call getRandomString()", String.class).getSingleResult();

    //    return UUID.randomUUID().toString();
  }
}
