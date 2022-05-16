package exceptions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class LogicExceptions extends Exception{
    public static final int EMPTY_FIELDS = 0;
    public static final int EMPTY_GAMES_DB = 1;
    public static final int EMPTY_COMPONENTS_DB = 2;
    public static final int ISNT_EXIST_ID = 3;

    private int value;

    public LogicExceptions(int value){
        this.value = value;
    }

    private List<String> messages = Arrays.asList(
            "Campos vacios, faltan campos necesarios para poder hacer la peticion",
            "La tabla de juegos esta vacia. Crea un juego.",
            "La tabla de componentes esta vacia. Crea un componente",
            "Ese id no existe"
    );

    @Override
    public String getMessage(){
        return messages.get(value);
    }
}
