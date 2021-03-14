package meinprojekt;


	@FunctionalInterface
	public interface UnaryOperation<T> {
		public T apply (T a);
	}

