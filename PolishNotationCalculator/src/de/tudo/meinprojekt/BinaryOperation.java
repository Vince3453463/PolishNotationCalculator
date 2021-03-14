package meinprojekt;

@FunctionalInterface
public interface BinaryOperation<T> {
	public T apply(T a, T b);
}