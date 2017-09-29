# Anko-ExpandableTextView

[![Download](https://api.bintray.com/packages/arslancharyev31/android/expandable-textview/images/download.svg) ](https://bintray.com/arslancharyev31/android/expandable-textview/_latestVersion)
[![Preview the app](https://img.shields.io/badge/Preview-Appetize.io-orange.svg)](https://appetize.io/app/38y5ut81hadtz8drptftt82qd8)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

An Expandable TextView for Android (Api 16+) which is entirely written in
[Kotlin](https://kotlinlang.org/) and takes advantage of [Anko](https://github.com/Kotlin/anko).
The library also handles configuration changes, so that the view remains
expanded/collapsed on configuration change. Extends from `AppCompatTextView`.

## Table of Contents

- [Demo project](#demo-project)
- [Getting started](#getting-started)
- [Usage](#usage)
  - [Supported features](#supported-features)
  - [Extensions](#extensions)
- [Documentation](#documentation)
  - [Useful xml attributes](#useful-xml-attributes)
  - [Important notes](#important-notes)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Demo Project

Take a look at the [demo project](demo)
with examples of using this library in Kotlin with [Anko DSL](https://github.com/Kotlin/anko/wiki/Anko-Layouts)
as well as in Java with traditional xml.

![Demo](http://i.imgur.com/66NjOpS.gif)

## Getting Started

The library is included in jCenter, so just add this dependency to your module level `gradle.build`:

```kotlin
dependencies {
    implementation 'tm.charlie.androidlib:expandable-textview:$LatestVersion'
}
```
Current latest version is: [![Download](https://api.bintray.com/packages/arslancharyev31/android/expandable-textview/images/download.svg)](https://bintray.com/arslancharyev31/android/expandable-textview/_latestVersion)

## Usage

1. Define the `etv_collapsedLines` xml attribute (`setCollapsedLines(int lines)` method in Java or `collapsedLines` property in Kotlin) to set the number of lines in collapsed state.
2. Provide unique `id` so that library could restore its state after configuration change.

Then use `ExpandableTextView` just as you would use any other `TextView`.

Xml snippet:
```xml
<tm.charlie.expandabletextview.ExpandableTextView
    android:id="@+id/expandable_textview"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:fontFamily="@font/lato_black"
    android:text="@string/lipsum"
    app:etv_collapsedLines="3"
    app:etv_animationDuration="200"/>
```

Java snippet:
```java
ExpandableTextView expandableTextView = findViewById(R.id.expandable_textview);
expandableTextView.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v){
        // Make this ExpandableTextView expand/collapse on click event
        ((ExpandableTextView) v).toggle();
    }
});
```

Kotlin snippet:
```kotlin
expandableTextView(text = lipsum) {
    id = R.id.expandable_textview
    typeface = ResourcesCompat.getFont(context, R.font.lato_black)
    collapsedLines = 3
    animationDuration = 200

    // State change listener
    onStateChange { oldState, newState -> toast("$oldState -> $newState") }

    // Make ExpandableTextView expand/collapse on click event
    onClick { toggle() }
}
```

### Supported features
- Setting maximum number of collapsed lines and maxim number of expanded lines via both xml and Kotlin/Java.
- Tracking the state of `ExpandableTextView` via read-only `state` property.
 [Documentation of possible states](https://arslancharyev31.github.io/Anko-ExpandableTextView/tm.charlie.expandabletextview/-expandable-text-view/-state/index.html).
  The state will be also automatically updated every time `text`, `collapsedLines` or `expandedLines` properties are changed.
- `ExpandableTextView` preserves expanded/collapsed state on configuration change, e.g. orientation change, if unique id is provided.

### Extensions

Additionally, library provides [extension function](https://kotlinlang.org/docs/reference/extensions.html)
for simple DSL layout building, like so:
```kotlin
expandableTextView(text = "Lorem ipsum...") {
    collapsedLines = 3
}
```
[More in demo project](demo/src/main/java/tm/charlie/expandabletextview/demo/KotlinActivity.kt).

## Documentation

Take a look at the library documentation with description of public functions and properties: http://arslancharyev31.github.io/Anko-ExpandableTextView

### Useful xml attributes

You can use `ExpandableTextView` in xml layouts in the same way as you would `TextView`.
The library provides following attributes in addition to the ones defined in `TextView`.

| Attribute name             | Format                                        | Description | Default |
| -------------------------|--------------------------------------------|-------------|---------|
| *etv_animationDuration* | integer >= 0 | Duration of expand/collapse animation in milliseconds. | 300 |
| *etv_collapsedLines* | integer >= 0 | Number of lines in collapsed state. Must not be greater than `etv_expandedLines`. |[`Integer.MAX_VALUE`](https://developer.android.com/reference/java/lang/Integer.html#MAX_VALUE) |
| *etv_expandedLines* | integer >= 0 | Number of lines in expanded state. Must not be less than `etv_collapsedLines`. | [`Integer.MAX_VALUE`](https://developer.android.com/reference/java/lang/Integer.html#MAX_VALUE) |

### Important notes
- Library overrides `android:ellipsize` attribute to `TruncateAt.END` in order to ensure correct behaviour,
therefore setting this attribute either via xml or programmatically will have no effect.
- Library extensively uses `android:maxLines` internally, therefore this attribute shouldn't be used.
Use `collapsedLines` or `expandedLines` instead.
- Library extensively overrides `android:layout_height` internally, therefore this attribute shouldn't be used.
You can set it to `wrap_content` in the layout editor.
- For quite obvious reasons, `collapsedLines` cannot be greater than `expandedLines` and vice versa - `expandedLines`
 cannot be less than `collapsedLines`. An `IllegalArgumentException` will be thrown if either of these rules is violated.

## Contributing

If you wish to send a pull request, please make sure to checkout from `develop` branch and merge with `develop` branch as well.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

This library was based on its Java counterpart: [Android-ExpandableTextView](https://github.com/Blogcat/Android-ExpandableTextView).