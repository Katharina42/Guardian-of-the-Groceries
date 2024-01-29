package io.everyonecodes.projectmodule.Item;

import org.ocpsoft.prettytime.PrettyTime;
import org.ocpsoft.prettytime.units.Hour;
import org.ocpsoft.prettytime.units.Millisecond;
import org.ocpsoft.prettytime.units.Minute;
import org.ocpsoft.prettytime.units.Second;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.function.Function;

@Service
public class ItemDTOMapper implements Function<Item, ItemDTO> {

    @Override
    public ItemDTO apply(Item item) {
        ItemDTO itemDTO = new ItemDTO(
                item.getId(),
                item.getName(),
                item.getExpirationDate(),
                item.getWastedDate(),
                item.getStorageLocation());

        PrettyTime prettyTime = new PrettyTime(Locale.forLanguageTag("en"));
        prettyTime.removeUnit(Hour.class);
        prettyTime.removeUnit(Minute.class);
        prettyTime.removeUnit(Second.class);
        prettyTime.removeUnit(Millisecond.class);
        var expirationDate = item.getExpirationDate();
        if (expirationDate == null) {
            itemDTO.setTimeDiff("");
        } else {
            var prettyTimeDiff = prettyTime.format(prettyTime.calculatePreciseDuration(expirationDate));
            itemDTO.setTimeDiff(prettyTimeDiff);
        }
        return itemDTO;
    }
}
