package com.laba.solvd.militaryProject.reflections;
import com.laba.solvd.militaryProject.Main;
import com.laba.solvd.militaryProject.enums.Branch;
import com.laba.solvd.militaryProject.exceptions.InvalidEquipmentException;
import com.laba.solvd.militaryProject.militaryEquipments.Helicopter;
import com.laba.solvd.militaryProject.militaryEquipments.MilitaryEquipmentAbstract;
import com.laba.solvd.militaryProject.militaryForces.AirForce;
import com.laba.solvd.militaryProject.militaryPersonnel.MilitaryPersonnelAbstract;
import org.apache.log4j.Logger;
import java.lang.reflect.*;
import java.util.Arrays;
import static com.laba.solvd.militaryProject.enums.Branch.AIR_FORCE;

public class ReflectionUsage {
    public static Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) throws IllegalArgumentException{

        Class<?> branchEnumClass = Branch.class;

//for fields
        Field[] branchFields = branchEnumClass.getDeclaredFields();
        for (Field field : branchFields) {
            log.info("Field Name: " + field.getName());
            log.info("Field Type: " + field.getType());
            log.info("Modifiers: " + Modifier.toString(field.getModifiers()));
        }

// for constructors
        Constructor<?>[] branchConstructors = branchEnumClass.getDeclaredConstructors();
        for (Constructor<?> constructor : branchConstructors) {
            log.info("Constructor Name: " + constructor.getName());
            log.info("Modifiers: " + Modifier.toString(constructor.getModifiers()));
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                log.info("Parameter Type: " + parameterType);
            }
        }

// for methods
        Method[] branchMethods = branchEnumClass.getDeclaredMethods();
        for (Method method : branchMethods) {
            log.info("Method Name: " + method.getName());
            log.info("Return Type: " + method.getReturnType());
            log.info("Modifiers: " + Modifier.toString(method.getModifiers()));
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                log.info("Parameter Type: " + parameterType);
            }
        }

        Class<?> airForceClass = AirForce.class;

// fields
        Field[] airForceFields = airForceClass.getDeclaredFields();
        Arrays.stream(airForceFields)
                .forEach(field -> {
                    log.info("Field Name: " + field.getName());
                    log.info("Field Type: " + field.getType());
                    log.info("Modifiers: " + Modifier.toString(field.getModifiers()));
                });

//  constructors
        Constructor<?>[] airForceConstructors = airForceClass.getDeclaredConstructors();
        Arrays.stream(airForceConstructors)
                .forEach(constructor -> {
                    log.info("Constructor Name: " + constructor.getName());
                    log.info("Modifiers: " + Modifier.toString(constructor.getModifiers()));
                    Class<?>[] parameterTypes = constructor.getParameterTypes();
                    Arrays.stream(parameterTypes)
                            .forEach(parameterType -> log.info("Parameter Type: " + parameterType));
                });

// methods
        Method[] airForceMethods = airForceClass.getDeclaredMethods();
        Arrays.stream(airForceMethods)
                .forEach(method -> {
                    log.info("Method Name: " + method.getName());
                    log.info("Return Type: " + method.getReturnType());
                    log.info("Modifiers: " + Modifier.toString(method.getModifiers()));
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    Arrays.stream(parameterTypes)
                            .forEach(parameterType -> log.info("Parameter Type: " + parameterType));
                });

        Class<?> militaryPersonnelClass = MilitaryPersonnelAbstract.class;

// fields
        Field[] militaryPersonnelFields = militaryPersonnelClass.getDeclaredFields();
        Arrays.stream(militaryPersonnelFields)
                .forEach(field -> {
                    log.info("Field Name: " + field.getName());
                    log.info("Field Type: " + field.getType());
                    log.info("Modifiers: " + Modifier.toString(field.getModifiers()));
                });

// constructors
        Constructor<?>[] militaryPersonnelConstructors = militaryPersonnelClass.getDeclaredConstructors();
        Arrays.stream(militaryPersonnelConstructors)
                .forEach(constructor -> {
                    log.info("Constructor Name: " + constructor.getName());
                    log.info("Modifiers: " + Modifier.toString(constructor.getModifiers()));
                    Class<?>[] parameterTypes = constructor.getParameterTypes();
                    Arrays.stream(parameterTypes)
                            .forEach(parameterType -> log.info("Parameter Type: " + parameterType));
                });

//methods
        Method[] militaryPersonnelMethods = militaryPersonnelClass.getDeclaredMethods();
        Arrays.stream(militaryPersonnelMethods)
                .forEach(method -> {
                    log.info("Method Name: " + method.getName());
                    log.info("Return Type: " + method.getReturnType());
                    log.info("Modifiers: " + Modifier.toString(method.getModifiers()));
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    Arrays.stream(parameterTypes)
                            .forEach(parameterType -> log.info("Parameter Type: " + parameterType));
                });



        try {
            MilitaryEquipmentAbstract airForceEquipment2 = new Helicopter("Army Helicopter", 200000.00, 5, AIR_FORCE);
            Field[] armyFields = airForceEquipment2.getClass().getDeclaredFields();
            for (Field field : armyFields) {
                if (field.getName().equalsIgnoreCase("Army Helicopter")) {
                    field.setAccessible(true);
                    field.set(airForceEquipment2.getName(), "Air Force Helicopter");
                }
            }
            log.info("Changed info->"+airForceEquipment2.getInfo());
        } catch (InvalidEquipmentException e) {
            log.error("Invalid entry: " + e.getMessage());
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }


    }
}
