package terminaloperations;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;


public class ImmutableCollectors {

    public static <T> Collector<T, ?, ImmutableSet<T>> toSet() {
        return new ImmutableSetCollector<>();
    }

    public static <T> Collector<T, ?, ImmutableList<T>> toList() {
        return new ImmutableListCollector<>();
    }

    private static class ImmutableSetCollector<T>
            implements Collector<T, ImmutableSet.Builder<T>, ImmutableSet<T>> {
        @Override
        public Supplier<ImmutableSet.Builder<T>> supplier() {
            return ImmutableSet::builder;
        }

        @Override
        public BiConsumer<ImmutableSet.Builder<T>, T> accumulator() {
            return ImmutableSet.Builder::add;
        }

        @Override
        public BinaryOperator<ImmutableSet.Builder<T>> combiner() {
            return (left, right) -> {
                left.addAll(right.build());
                return left;
            };
        }

        @Override
        public Function<ImmutableSet.Builder<T>, ImmutableSet<T>> finisher() {
            return ImmutableSet.Builder::build;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return EnumSet.of(Characteristics.UNORDERED);
        }
    }

    private static class ImmutableListCollector<T>
            implements Collector<T, ImmutableList.Builder<T>, ImmutableList<T>> {
        @Override
        public Supplier<ImmutableList.Builder<T>> supplier() {
            return ImmutableList::builder;
        }

        @Override
        public BiConsumer<ImmutableList.Builder<T>, T> accumulator() {
            return ImmutableList.Builder::add;
        }

        @Override
        public BinaryOperator<ImmutableList.Builder<T>> combiner() {
            return (left, right) -> {
                left.addAll(right.build());
                return left;
            };
        }

        @Override
        public Function<ImmutableList.Builder<T>, ImmutableList<T>> finisher() {
            return ImmutableList.Builder::build;
        }

        @Override
        public Set<Collector.Characteristics> characteristics() {
            return EnumSet.noneOf(Collector.Characteristics.class);
        }
    }
}
