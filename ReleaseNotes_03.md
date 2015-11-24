Here is a summary of the changes for the 0.3 version.

  * After a lot of debate, we decided that having a separate API project was not helping and decided to remove this project entirely.  This makes for a much simpler API as we do not need factory classes anymore and everything is a regular Java bean.

  * The merchant calculation callback and all notifications have been wrapped in a strongly typed class, so you need not parse the XML yourself anymore.

  * We have written a simple example of how the merchant calculation processor might be implemented.

  * We now support the 

&lt;allow-us-po-box&gt;

 tag.

  * Numerous bug fixes and documentation updates.

  * More comprehensive unit tests for the API classes.  See SettingUpTheDevEnvironment for some more details on that.
