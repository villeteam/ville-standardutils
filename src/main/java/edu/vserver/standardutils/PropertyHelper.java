package edu.vserver.standardutils;

import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;

public class PropertyHelper {

	// this method helps dealing with raw-property returned from
	// Container.getContainerProperty()
	@SuppressWarnings("rawtypes")
	public static void setPropVal(Property prop, Object val) {
		setValue((Property<?>) prop, val);
	}

	public static <T> void setValue(Property<T> prop, Object val) {
		if (prop == null) {
			throw new NullPointerException("Property 'prop' was null");
		} else if (!prop.getType().isAssignableFrom(val.getClass())) {
			throw new IllegalArgumentException(
					"Tried to set value of property=" + prop + "; the "
							+ "value (=" + val
							+ ")  was of incompatible type (required type: "
							+ prop.getType() + "; type of value: "
							+ val.getClass() + ").");

		} else {
			prop.setValue(prop.getType().cast(val));
		}
	}

	public static class GenericsAugmentedContainer extends IndexedContainer {

		// these methods act as if property-id was
		// actually a composite of
		// property-id and required-type of the property (although having two
		// properties differentiated only by value-type is not possible);
		// there could also be errors instead of doing nothing and returning
		// null

		/**
		 * 
		 */
		private static final long serialVersionUID = -7280539340777733114L;

		@SuppressWarnings("unchecked")
		public <T> Property<T> getContainerProperty(Object itemId,
				Object propertyId, Class<T> type) {
			Property<?> prop = super.getContainerProperty(itemId, propertyId);

			if (prop != null && type.isAssignableFrom(prop.getType())) {
				// this cast should be safe here
				return (Property<T>) prop;
			} else {
				return null;
			}
		}

		public <T> void setPropertyValue(Object itemId, Object propertyId,
				T value) {
			Property<?> prop = super.getContainerProperty(itemId, propertyId);
			if (prop != null
					&& prop.getType().isAssignableFrom(value.getClass())) {
				PropertyHelper.setValue(prop, value);
			}
		}

		public <T> T getPropertyValue(Object itemId, Object propertyId,
				Class<T> valType) {

			Property<?> prop = super.getContainerProperty(itemId, propertyId);
			if (valType.isAssignableFrom(prop.getType())) {
				return valType.cast(prop.getValue());
			} else {
				return null;
			}
		}
	}

}
