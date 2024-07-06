package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {

    private final String tagBody;
    private final List<Tag> tagsChildren;

    public PairedTag(
            String tagName,
            Map<String, String> tagAttributes,
            String tagBody,
            List<Tag> tagsChildren) {
        super(tagName, tagAttributes);
        this.tagBody = tagBody;
        this.tagsChildren = tagsChildren;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("<" + getTagName());
        for (Map.Entry<String, String> entry : getTagAttributes().entrySet()) {
            result.append(" ")
                .append(entry.getKey())
                .append("=\"")
                .append(entry.getValue())
                .append("\"");
        }
        result.append(">");
        result.append(tagBody);

        String tmp = tagsChildren.stream()
                .map(Tag::toString)
                .collect(Collectors.joining(""));

        result.append(tmp);
        String closingTag = "</" + getTagName() + ">";
        return result.append(closingTag).toString();
    }
}
// END
