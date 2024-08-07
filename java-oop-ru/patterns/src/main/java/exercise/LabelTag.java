package exercise;

// BEGIN
class LabelTag implements TagInterface {

    String text;
    TagInterface tag;

    public LabelTag(String text, TagInterface tag) {
        this.text = text;
        this.tag = tag;
    }

    @Override
    public String render() {
        return "<label>" + text + tag.render() + "</label>";
    }
}
// END
