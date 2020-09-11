package AxonDemo.AxonDemo.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
the most important thing to note here is the @TargetAggregateIdentifier annotation. Basically, this is an Axon specific
requirement to identify the aggregate instance. In other words, this annotation is required for Axon to determine the
instance of the Aggregate that should handle the command. The annotation can be placed on either the field or the getter
method. In this example, we chose to put it on the field.
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseCommand<T> {
  @TargetAggregateIdentifier
  private T id;
}
