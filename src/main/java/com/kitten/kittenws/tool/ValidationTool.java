package com.kitten.kittenws.tool;

import com.kitten.kittenws.exception.InvalidInputException;
import org.springframework.stereotype.Service;

@Service
public class ValidationTool {
    public boolean checkParsabilityToLong(String id, String url) {
        try{
            Long.parseLong(id);
            return true;
        } catch (NumberFormatException exception) {
            throw new InvalidInputException(url);
        }
    }
}
