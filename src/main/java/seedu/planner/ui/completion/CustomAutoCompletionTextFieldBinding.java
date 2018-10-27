package seedu.planner.ui.completion;

import java.util.Collection;

import org.controlsfx.control.textfield.AutoCompletionBinding;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * Class that represents the binding between a text field and a auto-completion popup
 */
public class CustomAutoCompletionTextFieldBinding<T> extends AutoCompletionBinding<T> {

    private String oldText = "";

    /**
     * String converter to be used to convert suggestions to strings.
     */
    private static <T> StringConverter<T> defaultStringConverter() {
        return new StringConverter<T>() {
            @Override public String toString(T t) {
                return t == null ? null : t.toString();
            }
            @SuppressWarnings("unchecked")
            @Override public T fromString(String string) {
                return (T) string;
            }
        };
    }

    private StringConverter<T> converter;

    /**
     * Creates a new auto-completion binding between the given textField
     * and the given suggestion provider.
     *
     * @param textField
     * @param suggestionProvider
     */
    public CustomAutoCompletionTextFieldBinding(final TextField textField,
                                                Callback<AutoCompletionBinding.ISuggestionRequest, Collection<T>>
                                                        suggestionProvider,
                                                final StringConverter<T> converter) {

        super(textField, suggestionProvider, converter);
        this.converter = converter;

        getCompletionTarget().caretPositionProperty().addListener(caretChangeListener);
        getCompletionTarget().focusedProperty().addListener(focusChangedListener);
    }

    public CustomAutoCompletionTextFieldBinding(final TextField textField,
                                                Callback<AutoCompletionBinding.ISuggestionRequest, Collection<T>>
                                                        suggestionProvider) {

        this(textField, suggestionProvider, CustomAutoCompletionTextFieldBinding
                .<T>defaultStringConverter());
    }



    @Override
    public TextField getCompletionTarget(){
        return (TextField)super.getCompletionTarget();
    }

    @Override
    public void dispose(){
        getCompletionTarget().caretPositionProperty().removeListener(caretChangeListener);
        getCompletionTarget().focusedProperty().removeListener(focusChangedListener);
    }

    @Override
    protected void completeUserInput(T completion){
        String newText = oldText + converter.toString(completion);
        getCompletionTarget().setText(newText);
        getCompletionTarget().positionCaret(newText.length());
    }

    private final ChangeListener<Number> caretChangeListener = new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> obs, Number oldNumber, Number newNumber) {
            String text = getCompletionTarget().getText().substring(0, newNumber.intValue());
            int index ;
            for (index = text.length() - 1; index >= 0 && ! Character.isWhitespace(text.charAt(index)); index--);
            if (index > 0) {
                oldText = text.substring(0, index) + " ";
            } else {
                oldText = "";
            }
            String newText = text.substring(index+1, text.length());
            if (getCompletionTarget().isFocused()) {
                setUserInput(newText);
            }
        }
    };

    private final ChangeListener<Boolean> focusChangedListener = new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> obs, Boolean oldFocused, Boolean newFocused) {
            if (newFocused == false){
                hidePopup();
            }
        }
    };

}