package fi.utu.ville.standardutils;

import java.io.Serializable;

/**
 * Class for constants that are used to retrieve correct content for ViLLE's UI. <br>
 * <br>
 * <strong>Note!</strong> Do NOT edit the string values in this class!<br>
 * <br>
 * The values of constants are used to retrieve correct text in correct language
 * using UILanguage class.<br>
 * If you wish to change a UI text, edit the file <code>English.lan</code> which
 * can be found in edu.vserver.resources.language package.
 * 
 * @author ertaka
 * 
 */
public class UIConstants implements Serializable {

	private static final long serialVersionUID = -4111712512819095369L;

	public static final String BUG_REPORTER_HEADER = "This shouldn't happen.";

	public static final String BUG_REPORTER_INFO_NOTIFICATION = "Fortunately, we'll get a notification about this problem, and we'll start fixing the problem as soon as we can.";

	public static final String BUG_REPORTER_TITLE_TEXTFIELD_LABEL = "Title";

	public static final String BUG_REPORTER_DESCRIPTION_LABEL_CAPTION = "You can speed up the repair process by describing briefly, what you were doing when the error occured:";

	public static final String BUG_REPORTER_I_CAN_BE_CONTACTED_LABEL_CAPTION = "I can be contacted by e-mail on this error";

	public static final String BUG_REPORTER_TITLE_AND_DESCRIPTION_MUST_BE_NON_EMPTY = "Title and description must be non-empty";

	public static final String OK = "OK";

	public static final String DONE = "Done";

	public static final String USER = "User";

	public static final String PREVIOUS_MESSAGE_ALL_CAPS = "PREVIOUS MESSAGE";

	public static final String LOG_OUT = "Log out";

	public static final String CLICK_TO_SWITCH_TO_MAIN_VIEW = "Click to switch back to main view";

	public static final String ROUND_IS_CLOSED = "The round is closed";

	public static final String POINTS = "points";

	public static final String SUBMISSIONS = "submissions";

	public static final String OPENED = "Opened";

	public static final String OPENS = "Opens";

	public static final String CLOSED = "closed";

	public static final String CLOSES = "closes";

	public static final String ASSIGNMENT = "assignment";

	public static final String VIEW_PROFILE = "View profile";

	public static final String CHECKBOX = "Checkbox";

	public static final String CHECKBOX_EXPLANATION = "Add a yes / no type question";

	public static final String OPTIONS = "Options";

	public static final String OPTIONS_EXPLANATION = "Add a question with multiple options";

	public static final String TEXTFIELD = "Textfield";

	public static final String TEXTFIELD_EXPLANATION = "Add a single row text field";

	public static final String TEXTBOX = "Textbox";

	public static final String TEXTBOX_EXPLANATION = "Add a multirow text field";

	public static final String SCALE = "Scale";

	public static final String SCALE_EXPLANATION = "Add a question wich is answered in scale of (1...n)";

	public static final String EXPLANATION = "Explanation";

	public static final String EXPLANATION_EXPLANATION = "Add an explanation about question(s)";

	public static final String SAVE = "Save";

	public static final String PREVIEW = "Preview";

	public static final String EDIT = "Edit";

	public static final String DELETE = "Delete";

	public static final String ADD = "Add";

	public static final String MAXIMUM_LENGTH = "Maximum length";

	public static final String NUMBER_OF_ROWS = "Number of rows";

	public static final String SCALE_FROM = "From";

	public static final String SCALE_TO = "To";

	public static final String STEP = "Step";

	public static final String OPTION = "Option";

	public static final String TOOLTIP_EDIT_ELEMENT = "Click to edit this element";

	public static final String TOOLTIP_MOVE_ELEMENT_UP = "Click to move element up";

	public static final String TOOLTIP_MOVE_ELEMENT_DOWN = "Click to move element down";

	public static final String TOOLTIP_DELETE_ELEMENT = "Click to delete this element";

	public static final String EXERCISE_NAME = "Exercise name";

	public static final String DEFAULT_DESCRIPTION = "Default description";

	public static final String NOTES_FOR_TEACHERS = "Notes for teachers";

	public static final String HIDE_DESCRIPTIONS = "Hide descriptions";

	public static final String SHOW_DESCRIPTIONS = "Show descriptions";

	public static final String UPLOAD = "Upload";

	public static final String UPLOAD_ERROR_WRONG_FILE_TYPE = "Error in upload: Wrong file type.";

	public static final String UPLOAD_EXPLANATION = "Add an upload field";

	public static final String DESCRIPTION = "Description";

	public static final String MAXIMUM_FILE_SIZE_IN_KB = "Maximum file size (in kilobytes)";

	public static final String ERROR_NO_VALUE_IN_ALL_FIELDS = "There is no value in one or more fields!";

	public static final String VILLE_CLOUDS_AND_BOXES = "ViLLE Clouds and Boxes Exercise";

	public static final String VILLE_VISUALIZATION_EXERCISE = "ViLLE Visualization Exercise";

	public static final String VILLE_SORTING_EXERCISE = "ViLLE Sorting Exercise";

	public static final String VILLE_CODING_EXERCISE = "ViLLE Coding Exercise";

	public static final String VILLE_QUIZ_EXERCISE = "ViLLE Quiz Exercise";

	public static final String SURVEY_EXERCISE = "Survey";

	public static final String SELECT_EXERCISE_TYPE = "Select exercise type";

	public static final String SURVEY_EDITOR = "Survey editor";

	public static final String CLOSE_WINDOW = "Close window";

	public static final String REGISTER_TO_VILLE = "Register to ViLLE and to @0.";

	public static final String NAME = "Name";

	public static final String EMAIL_ADDRESS = "E-mail address";

	public static final String EDUCATIONAL_INSTITUTE = "Educational institute";

	public static final String STUDENT_NUMBER_OR_OTHER_CODE = "Student number or other id code";

	public static final String SELECT_PASSWORD = "Select a password";

	public static final String PASSWORD = "Password";

	public static final String TYPE_PASSWORD_AGAIN = "Type the password again to verify correctness";

	public static final String FINALLY_ENTER_COURSE_KEY = "Finally, enter the course key to register";

	public static final String COURSE_KEY = "Course key";

	public static final String REGISTER = "Register";

	public static final String ENTER_PERSONAL_DATA = "Enter personal data";

	public static final String NEW_TO_VILLE_FILL_DETAILS = "New to ViLLE? Fill out your details below!";

	public static final String ALREADY_HAVE_VILLE_ACCOUNT = "Already have a ViLLE account?";

	public static final String ENTER_YOUR_INITIALS_BELOW = "Enter your initials below!";

	public static final String ENROLL_INTO_COURSE = "Enroll into @0.";

	public static final String ENROLL = "Enroll";

	public static final String ERROR_FIELD_VALUE_MISSING = "Field '@0' is required!";

	public static final String ERROR_PASSWORDS_DONT_MATCH = "Passwords don't match!";

	public static final String ERROR_INCORRECT_COURSE_KEY = "Incorrect course key for this course!";

	public static final String ERROR_CLOSE_BROWSER_AND_TRY_AGAIN = "Please close web browser and try again.";

	public static final String ERROR_EMAIL_ADDRESS_TAKEN = "The e-mail address is already taken!";

	public static final String REGISTRATION_SUCCESSFUL = "Registration successful, please login!";

	public static final String ERROR_IN_REGISTRATION = "Error in registration, please try again!";

	public static final String ERROR_EMAIL_PASSWORD_DONT_MATCH = "Incorrect email and password combination!";

	public static final String SUCCESFULLY_ENROLLED_INTO_COURSE = "Succesfully enrolled into @0!";

	public static final String NO_COMMENTS_YET = "No comments yet.";

	public static final String COMMENT = "Comment";

	public static final String POST_COMMENT = "Post comment";

	public static final String POSTED_IN = "in";

	public static final String ERROR_INCORRECT_EMAIL_FORMAT = "Incorrect email address format!";

	public static final String IMPORT = "Import";

	public static final String NEW_FOLDER = "New folder";

	public static final String NEW_EXERCISE = "New exercise";

	public static final String TEST_EXERCISE = "Test exercise";

	public static final String EXERCISE_TYPE = "Exercise type";

	public static final String NAME_MISSING = "Name missing";

	public static final String FOLDER_NAME = "Folder name";

	public static final String SELECT_FOLDER = "Select folder";

	public static final String IMPORTING = "Importing";

	public static final String ERROR_IN_IMPORT = "Error in import";

	public static final String VILLE_EDITOR = "ViLLE editor";

	public static final String PAGE_BREAK = "Page break";

	public static final String PAGE_BREAK_EXPLANATION = "Add a page break";

	public static final String NEXT_PAGE = "Next page";

	public static final String PREVIOUS_PAGE = "Previous page";

	public static final String PAGE_NUMBER_OF_NUMBER = "Page @0 of @1";

	public static final String COURSE_STATISTICS = "Course statistics";

	public static final String STUDENT_PERFORMANCE = "Student performance";

	public static final String COURSE = "Course";

	public static final String ROUNDS = "Rounds";

	public static final String COURSE_TOTAL_MAXIMUM_POINTS = "Course total maximum points";

	public static final String ROUNDS_OPEN_UNTIL_NOW = "Rounds open until now";

	public static final String ASSIGNMENTS_OPEN_UNTIL_NOW = "Assignments open until now";

	public static final String COURSE_TOTAL_MAXIMUM_POINTS_UNTIL_NOW = "Course total maximum points until now";

	public static final String STUDENTS_REGISTERED = "Students registered";

	public static final String AVERAGE_SUBMISSIONS_PER_STUDENT = "Average submissions per student";

	public static final String AVERAGE_TOTAL_SCORE_PER_STUDENT = "Average total score per student";

	public static final String AVERAGE_PERCENT_OF_MAXIMUM_SCORE_PER_STUDENT = "Average percent of maximum score achieved per student";

	public static final String TOTAL_TIME_USED_IN_THIS_COURSE = "Total time used in this course";

	public static final String AVERAGE_TIME_USED_IN_COURSE = "Average time used in this course by student";

	public static final String BEST_ASSIGNMENT_BY_POINTS = "Best assignment by average points achieved";

	public static final String MOST_TIME_USED_ASSIGNMENT = "Most time used in assignment (average of all students)";

	public static final String BEST_ROUND_BY_POINTS = "Best round by average points achieved";

	public static final String MOST_TIME_USED_ROUND = "Most time used in round (average of all students)";

	public static final String WORST_ROUND_BY_POINTS = "Worst round by average points achieved";

	public static final String LEAST_TIME_USED_ASSIGNMENT = "Least time used in assignment (average of all students)";

	public static final String LEAST_TIME_USED_ROUND = "Least time used in round (average of all students)";

	public static final String BEST_ASSIGNMENT_SCORE_PER_TIME = "Best assignment by score per time ratio";

	public static final String WORST_ASSIGNMENT_SCORE_PER_TIME = "Worst assignment by score per time ratio";

	public static final String BEST_ROUND_SCORE_PER_TIME = "Best round by score per time ratio";

	public static final String WORST_ROUND_SCORE_PER_TIME = "Worst round by score per time ratio";

	public static final String BEST_ASSIGNMENT_RATING = "Best assignment by student rating";

	public static final String WORST_ASSIGNMENT_RATING = "Worst assignment by student rating";

	public static final String MOST_RATED_ASSIGNMENT = "Most rated assignment";

	public static final String MOST_COMMENTED_ASSIGNMENT = "Most commented assignment";

	public static final String AVERAGE_RATINGS_PER_ASSIGNMENT = "Average ratings per assignment";

	public static final String AVERAGE_COMMENTS_PER_ASSIGNMENT = "Average comments per assignment";

	public static final String NUMBER_OF_ASSIGNMENTS = "Number of assignments";

	public static final String NUMBER_OF_SUBMISSIONS = "Number of submissions";

	public static final String AVERAGE_SUBMISSION_SCORE = "Average submission score";

	public static final String BEST_ASSIGNMENT_BY_AVG_OF_ALL_SUBMISSION = "Best assignment by average of all submissions";

	public static final String AVERAGE_TIME_USED_IN_ASSIGNMENT = "Average time used in assignment";

	public static final String WORST_ASSIGNMENT_BY_AVG_OF_ALL_SUBMISSIONS = "Worst assignment by average of all submissions";

	public static final String COURSE_TOTAL_STATISTICS = "Course total statistics";

	public static final String INCLUDE_SURVEYS = "Include surveys";

	public static final String SHOW_STATISTICS_FOR_ALL_ASSIGNMENTS = "Show statistics for all assignments";

	public static final String HIDE_STATISTICS_FOR_ALL_ASSIGNMENTS = "Hide statistics for all assignments";

	public static final String ASSIGNMENT_NAME = "Assignment name";

	public static final String AVERAGE_SCORE = "Average score";

	public static final String AVERAGE_TIME_ON_TASK = "Average time on task";

	public static final String SCORE_PER_SECOND_RATIO = "Score per second ratio";

	public static final String SELECT_COURSE_TO_VIEW = "Select course to view";

	public static final String SHOW = "Show";

	public static final String SCORES = "Scores";

	public static final String TIME_USED = "Time used";

	public static final String DISPLAY_VALUES = "Display values";

	public static final String BEST_SUBMISSION = "Best submission";

	public static final String AVG_OF_ALL_SUBMISSIONS = "Average of all submissions";

	public static final String TOTAL_TIME_USED = "Total time used";

	public static final String BACK_TO_COURSE_VIEW = "Back to the course view";

	public static final String BACK_TO_ROUND_VIEW = "Back to the round view";

	public static final String NO_RATING = "No ratings";

	public static final String TOTAL = "Total";

	public static final String RATINGS = "ratings";

	public static final String TO_PREVIOUS = "To previous assignment";

	public static final String TO_NEXT = "To next assignment";

	public static final String WELCOME = "Welcome";

	public static final String RESULT_SUBMITTED_SCORE = "Result submitted: score";

	public static final String SURVEYS = "Surveys";

	public static final String ERROR_COURSE_HAS_NO_SURVEYS = "This course has no survey type assignments!";

	public static final String TOOLTIP_VIEW_USERS_ANSWERS = "Click to view the answers of this user";

	public static final String ANSWERS_FOR_USER = "Answer for user @0";

	public static final String ANSWER_LABEL = "Answer:";

	public static final String CUBIC_TASK1 = "Cubic task 1";

	public static final String CUBIC_TASK2 = "Cubic task 2";

	public static final String CUBIC_TASK3 = "Cubic task 3";

	public static final String CUBIC_HELPER_MESSAGE1 = "Cubic helper message 1";

	public static final String CUBIC_HELPER_MESSAGE2 = "Cubic helper message 2";

	public static final String CUBIC_HELPER_MESSAGE3 = "Cubic helper message 3";

	public static final String CUBIC_HELPER_MESSAGE4 = "Cubic helper message 4";

	public static final String TIME_USED_TO_FILL_THIS_PAGE = "Time used to fill this page";

	public static final String ERROR_IN_UPLOAD = "There was an error in upload, please try again!";

	public static final String DOWNLOAD = "Download";

	public static final String ERROR_FILE_TOO_LARGE = "File size is too big! Maximum size is @0 kb.";

	public static final String NOTIFICATION_UPLOADING_FILE = "Uploading file, please wait a moment...";

	public static final String EXPORT_FILE_FORMAT = "Export file format";

	public static final String TEXT_FILE = "Text file";

	public static final String MS_EXCEL_SPREADSHEET = "Microsoft Excel spreadsheet";

	public static final String FILENAME = "File name";

	public static final String EXPORT = "Export data";

	public static final String ERROR_FILE_NAME_MISSING = "You must give a file name to export!";

	public static final String ROUNDS_TITLE = "Rounds title";

	public static final String JOIN_ROUNDS_INTO_SINGLE_TABLE = "Join rounds into single table";

	public static final String ASSIGNMENTS_TITLE = "Assignments title";

	public static final String EXPORT_SOURCE = "Export source";

	public static final String CURRENT_VIEW = "Current view";

	public static final String CUSTOM = "Custom...";

	public static final String INCLUDE_FIELDS = "Include fields";

	public static final String DELIMIT_FIELDS_BY = "Delimit fields by";

	public static final String INCLUDE_UPLOAD_COLUMNS = "Include upload columns";

	public static final String VALUE_TYPES = "Value types";

	public static final String SCORE = "Score";

	public static final String BOOKMARK_SAVED = "Bookmark saved!";

	public static final String ADD_BOOKMARK = "Add bookmark";

	public static final String BOOKMARKS = "Bookmarks";

	public static final String VIEW = "View";

	public static final String RESTORE_BOOKMARKS_VIEW = "Restore Bookmarks view";

	public static final String ERROR_SELECT_BOOKMARK_TO_VIEW_IT = "Select a boookmark to view it!";

	public static final String VISIBLE_FOR_OTHER_TEACHERS = "Visible for other teachers";

	public static final String BROWSE = "Browse";

	public static final String OWN_MATERIALS = "Own materials";

	public static final String OTHER_PUBLIC_MATERIALS = "Other public materials";

	public static final String SEARCH_MATERIALS = "Search materials";

	public static final String BOOKMARKED_MATERIALS = "Bookmarked materials";

	public static final String ATTACHED_MATERIALS = "Attached materials";

	public static final String OWNER = "Owner";

	public static final String ADD_MATERIAL = "Add material";

	public static final String TOOLTIP_ADD_MATERIAL = "Upload or create a new material";

	public static final String SEARCH = "Search";

	public static final String SEARCH_FROM = "Search from";

	public static final String TYPE = "Type";

	public static final String RATING = "Rating";

	public static final String ATTACHED_TO_NUMBER_OF_RESOURCES = "Attached to # of resources";

	public static final String ERROR_IN_DATABASE_ACTION = "Error in database action!";

	public static final String ERROR_MATERIAL_IN_USE = "You can not hide a material that is in use by other teachers!";

	public static final String MATERIAL_SAVED = "Material saved!";

	public static final String CONFIRM_FOLDER_DELETE = "Confirm Folder Delete";

	public static final String THE_FOLDER_IS_NOT_EMPTY_SURE_TO_DELETE = "This folder is not empty! Are you sure you want to delete it and all resources in it?";

	public static final String FOLDER_REMOVED = "Folder @0 removed!";

	public static final String ERROR_NO_FILE_UPLOADED_IN_ADD_MATERIAL = "No file uploaded - please upload a file to add new material!";

	public static final String BROWSE_MATERIALS = "Browse materials";

	public static final String NEWEST = "Newest";

	public static final String BEST = "Best";

	public static final String MOST_COMMENTED = "Most commented";

	public static final String MOST_POPULAR = "Most popular";

	public static final String FILEFORMAT_TEXT = "Text";

	public static final String FILEFORMAT_PDF = "Pdf";

	public static final String FILEFORMAT_IMAGE = "Image";

	public static final String FILEFORMAT_HTML = "HTML";

	public static final String FILEFORMAT_WORD = "MS Word";

	public static final String FILEFORMAT_EXCEL = "MS Excel";

	public static final String FILEFORMAT_PP = "MS PowerPoint";

	public static final String FILEFORMAT_FLASH = "Flash";

	public static final String FILEFORMAT_VIDEO = "Video";

	public static final String FILEFORMAT_APPLICATION = "Application";

	public static final String FILEFORMAT_AUDIO = "Audio";

	public static final String FILEFORMAT_OTHER = "Other";

	public static final String SEARCH_TARGET = "Search target";

	public static final String TAGS = "Tags";

	public static final String RESULTS = "Results";

	public static final String OWN_COURSES = "Own courses";

	public static final String BROWSE_COURSES = "Browse courses";

	public static final String SEARCH_COURSES = "Search courses";

	public static final String BOOKMARKED_COURSES = "Bookmarked courses";

	public static final String NEW_COURSE = "New course";

	public static final String COPY_COURSE = "Copy course";

	public static final String OPEN = "Open";

	public static final String STATE = "State";

	public static final String IS_CLOSED = "Is closed";

	public static final String TIMES_COPIED = "Times copied";

	public static final String ERROR_TOO_MANY_COURSES = "You have reached the limit of @0 courses!";

	public static final String ERROR_TOO_MANY_COURSE_SUBTEXT = "Please delete one of the existing courses to create a new one.";

	public static final String TEST_COURSE = "Test course";

	public static final String CONFIRM_COURSE_DELETE = "Confirm course delete";

	public static final String CONFIRM_COURSE_DELETE_QUESTION = "All details, assignments and enrollment data for this course will be deleted too. Are you sure?";

	public static final String COURSE_DELETED = "Deleted course @0.";

	public static final String USED_IN_ASSIGNMENTS = "Used in assignments";

	public static final String SEARCH_EXERCISES = "Search exercises";

	public static final String OWN_EXERCISES = "Own exercises";

	public static final String BROWSE_EXERCISES = "Browse exercises";

	public static final String BOOKMARKED_EXERCISES = "Bookmarked exercises";

	public static final String USE_EXERCISE = "Use exercise";

	public static final String SURVEY = "Survey";

	public static final String COPY_ROUND = "Copy round";

	public static final String MATERIAL = "Material";

	public static final String ERROR_CANT_DELETE_EXERCISE = "Can't delete exercise!";

	public static final String ERROR_CANT_DELETE_EXERCISE_SUBTEXT = "This exercise is in use in one or more assignments.";

	public static final String CONFIRM_EXERCISE_DELETE = "Confirm exercise deletion";

	public static final String CONFIRM_EXERCISE_DELETE_QUESTION = "Are you sure you want to delete this exercise?";

	public static final String MAX_POINTS = "Max points";

	public static final String SELECT_COURSE_AND_ROUND_TO_INSERT_ASSIGNMENT = "Select course and round to insert new assignment into:";

	public static final String ASSIGNMENT_ADDED = "Assignment added!";

	public static final String ERROR_CANT_DELETE_FOLDER = "Folder is not empty.";

	public static final String ERROR_CANT_DELETE_FOLDER_SUBTEXT = "Delete items in folder before deleting it!";

	public static final String ERROR_CANT_DELETE_FOLDER_LAST_FOLDER = "You have to have at least one folder!";

	public static final String ITEMS_PER_PAGE = "Items per page";

	public static final String EXERCISE_SAVED = "Exercise saved!";

	public static final String TOTAL_OF_ITEMS = "Total of @0 items.";

	public static final String ATTACH_MATERIALS_TO_ELEMENT = "Attach materials to element";

	public static final String ATTACH = "Attach";

	public static final String ERROR_SELECT_A_MATERIAL = "Select a material!";

	public static final String TARGET_LINK_IN_MATERIAL = "Target link in material";

	public static final String MATERIAL_ATTACHED = "Material attached!";

	public static final String CREATED = "Created";

	public static final String SAVE_EXERCISE = "Save exercise";

	public static final String EXERCISE_ATTACHED_TO_OWN_ASSIGNMENTS = "The exercise is attached to your own assignment(s).";

	public static final String SELECT_ASSIGNMENTS_YOU_WANT_TO_UPDATE_WITH_NEW_EXERCISE = "Please select the assignments you want to update with the modified exercise:";

	public static final String SAVING_NEW_EXERCISE = "Saving new exercise.";

	public static final String NOT_OWNER_OF_EXERCISE_COPY_WILL_BE_SAVED = "Since you are not the owner of this exercise, a copy will be saved.";

	public static final String EXERCISE_ATTACHED_TO_ASSIGNMENTS_COPY_WILL_BE_SAVED = "This exercise is attached to one or more assignments. A copy will be saved.";

	public static final String NO_STUDENTS_REGISTERED_INTO_COURSES = "There are no users registered into any of your courses.";

	public static final String TOP_EXERCISES_IN_COURSE_RATED_BY = "Top exercises in course, rated by:";

	public static final String MORE_LINK = "more...";

	public static final String TEACHERS = "Teachers";

	public static final String STUDENTS = "Students";

	public static final String DIFFICULTY = "Difficulty";

	public static final String PROGRAMMING_LANGUAGE = "Programming language";

	public static final String LANGUAGE = "Language";

	public static final String UPDATING_EXERCISE = "Updating exercise.";

	public static final String ERROR_SELECT_ROUND_TO_ADD_ASSIGNMENT = "Please select a round to add this exercise into!";

	public static final String EXPLORER = "Explorer";

	public static final String SELECT_EXERCISE_TO_VIEW = "Select exercise to view";

	public static final String TAGS_ATTACHED = "Tags attached:";

	public static final String NO_TAGS = "No tags";

	public static final String EDIT_TAGS = "Edit tags";

	public static final String TAGS_AVAILABLE = "Tags available";

	public static final String NEW_TAG = "New tag";

	public static final String PREFERENCES = "Preferences";

	public static final String COURSES_AND_EXERCISES_CREATED = "Courses / exercises created:";

	public static final String NUMBER_OF_COMMENTS_WRITTEN = "Number of comments written:";

	public static final String NUMBER_OF_RATINGS_GIVEN = "Number of ratings given:";

	public static final String AVG_RATING_GIVEN = "Average rating given:";

	public static final String PERSONAL_STATISTICS = "Personal statistics";

	public static final String REMOVE_FROM_COURSE = "Remove from course";

	public static final String SEARCH_STUDENT = "Search student";

	public static final String SELECT_MATERIAL_TO_VIEW = "Select material to view";

	public static final String STATISTICS = "Statistics";

	public static final String ADD_ASSIGNMENTS = "Add assignments";

	public static final String ADD_ROUND = "Add round";

	public static final String COURSE_SETTINGS = "Course settings";

	public static final String REGISTRATION_LINK_FOR_STUDENTS = "Registration link for students";

	public static final String REGISTRATION_KEY = "Registration key";

	public static final String COURSE_SAVED = "Course saved!";

	public static final String REGISTRATION_BEGINS = "Registration begins";

	public static final String REGISTRATION_ENDS = "Registration ends";

	public static final String ROUNDS_IN_COURSE = "Rounds in course";

	public static final String CLICK_TO_VIEW_DETAILS_ASSIGNMENTS = "Click to view details & assignments";

	public static final String EDIT_ROUND_DETAILS = "Edit round details";

	public static final String CONFIRM_ROUND_DELETE = "Confirm round delete";

	public static final String CONFIRM_ROUND_DELETE_MESSAGE = "Are you sure you want to delete this round and all assignments in it?";

	public static final String EDIT_ASSIGNMENT = "Edit assignment";

	public static final String CONFIRM_USER_REMOVAL = "Confirm user removal";

	public static final String CONFIRM_USER_REMOVAL_MESSAGE = "Are you sure you want to remove student '@0' from this course?";

	public static final String USER_REMOVED = "Removed user @0.";

	public static final String NO_RESULTS = "No results.";

	public static final String ERROR_NO_COURSES_FOUND = "No courses found.";

	public static final String ERROR_NO_COURSES_FOUND_MESSAGE = "Create a course and a round to it first to utilize exercises!";

	public static final String MENU_ITEM_COURSES = "Menu Item Courses";

	public static final String MENU_ITEM_EXERCISES = "Menu Item Exercises";

	public static final String MENU_ITEM_PROFILE = "Menu Item Profile";

	public static final String MENU_ITEM_STUDENTS = "Menu Item Students";

	public static final String MENU_ITEM_MATERIALS = "Menu Item Materials";

	public static final String MENU_ITEM_STATISTICS = "Menu Item Statistics";

	public static final String MENU_ITEM_RESEARCHPROJECTS = "Menu Item Research Projects";

	public static final String RESEARCHPROJECTS_BULLETIN_BOARD = "Bulletin board";
	public static final String RESEARCHPROJECTS_EXPLORER = "Research projects explorer";
	public static final String RP_RESOURSE_EXPLORER = "Resource explorer";
	public static final String RESEARCHPROJECTS_TO_VIEW = "Select a research project to view";
	public static final String RESEARCHPROJECTS_SELECTED = "Selected research project info. Select a resource to view";
	public static final String RESEARCHPROJECTS_BB_TITLE = "Bulletin Board Title";
	public static final String RESEARCHPROJECTS_BB_FOUNDER = "Bulletin Board Founder";
	public static final String RESEARCHPROJECTS_BB_NUMOFP = "Bulletin Board Participants";
	public static final String RESEARCHPROJECTS_BB_STATE = "Bulletin Board State";
	public static final String RESEARCHPROJECTS_BB_DATE = "Bulletin Board Date created";
	public static final String RESEARCHPROJECTS_BB_PAPRTIPANTOF = "am I a Participant";
	public static final String RESEARCHPROJECTS_MEMBERAPPLIED = "Project membership applied, wait for approval from project's staff.";
	public static final String RESEARCHPROJECTS_APPLIED = "Applied";
	public static final String RESEARCHPROJECTS_DELETED = "Research project was deleted from the system.";

	public static final String RP_ADD_RPROJECT = "Add project";
	public static final String RP_ADD_RPROJECT_TOOL_TIP = "Create new research project";
	public static final String RP_EDIT = "Edit project settings";
	public static final String RP_DELETE_RPROJECT = "Delete project";
	public static final String RP_DELETE_RPROJECT_TOOL_TIP = "Delete selected research project";

	public static final String RP_ADD_RESOURCE = "Add resource";
	public static final String RP_ADD_RESOURCE_TOOL_TIP = "Add resource to the project";
	public static final String RP_EDIT_RESOURCE = "Edit resource";
	public static final String RP_EDIT_RESOURCE_TOOL_TIP = "Edit resource settings";
	public static final String RP_DELETE_RESOURCE = "Delete resource";
	public static final String RP_DELETE_RESOURCE_TOOL_TIP = "Delete selected resource from the project";
	public static final String RP_RESOURCES = "Resources";
	public static final String RP_EDIT_PARTICIPANTS = "Edit Participants";
	public static final String RP_SELECT_RESOURCE_TYPE = "Please select resource type";
	public static final String RP_EDIT_PARTICIPANTS_TOOL_TIP = "Click this button to edit participants in this research project...";
	public static final String RP_BACK_TO_ALL_PROJECT = "All projects view";
	public static final String RP_BACK_TO_ALLPROJECT_TOOL_TIP = "Return to research project explorer view...";
	public static final String RP_EXTRAINFO = "Extra information for project's participants";
	public static final String RP_TOTALLYPUBLIC = "Resources are available only to participants of this project.";

	public static final String RP_JOIN_RPROJECT = "Join project";
	public static final String RP_TOOLTIP_JOIN_RPROJECT = "Click to join the selected research project";

	public static final String RP_JOIN_DIALOG_CAPTION = "Join a research project";
	public static final String RP_JOIN_QUESTION = "Do you want to join to the selected research project";
	public static final String RP_DELETE_DIALOG_CAPTION = "Delete a research project";
	public static final String RP_DELETE_DIALOG_QUESTION = "Do you want to delete this research project";

	public static final String RP_ROLE = "Role";
	public static final String RP_ACTION = "Action";
	public static final String RP_MEMBERSHIPSTATUS = "Status";
	public static final String RP_EDIT_PARTICIPANTS_ASSIGN_ROLE = "Applied: Assign a Role for me";
	public static final String RP_CLOSE = "Close";
	public static final String RP_DELETE_USER = "Delete user";
	public static final String RP_FOUNDER = "Founder";
	public static final String RP_COFOUNDER = "Co-founder";
	public static final String RP_STATE = "Project state";
	public static final String RP_PARTICIPANTS = "Participants";
	public static final String RP_PARTICIPANT = "Participant";
	public static final String RP_VIEWER = "Viewer";
	public static final String RP_DESC_DESCRIPTION = "Project's description";
	public static final String RP_SAVE_CHANGES = "Save changes";
	public static final String RP_USER_NAME = "Username";
	public static final String RP_RESOURCE_TITLE = "Title";
	public static final String RP_SELECTED_RESOURCE = "Selected resource";
	public static final String RP_SELECTED_PROJECT = "Selected project";

	public static final String RP_USE_RESOURCE = "Use resource";
	public static final String RP_USE_RESOURCE_TOOL_TIP = "Use resource in your own course";

	public static final String RP_SELECT = "Select this exercise";
	public static final String RP_SELECT_FIRST = "No selected exercise";
	public static final String RP_LINKTOANONYMOUS = "Link";

	public static final String SAVED = "Saved";
	public static final String FILE = "File";
	public static final String MESSAGES = "Messages";

	public static final String NO_MESSAGE_SUBJECT = "No subject";

	public static final String NEW_MESSAGE = "New message";

	public static final String FORWARD_MESSAGE = "Forward message";

	public static final String DELETE_MESSAGE = "Delete message";

	public static final String INBOX = "Inbox";

	public static final String SENT_MESSAGES = "Sent messages";

	public static final String DATE = "Date";

	public static final String SENDER = "Sender";

	public static final String SUBJECT = "Subject";

	public static final String MESSAGE = "Message";

	public static final String RECIPIENT = "Recipient";

	public static final String GET_MESSAGES = "Get messages";

	public static final String REPLY = "Reply";

	public static final String CONTACTS = "Contacts";

	public static final String NO_CONTACTS = "No contacts.";

	public static final String SELECT_RECIPIENTS = "Select recipient(s)";

	public static final String SEND_MSG_TO = "Send message to:";

	public static final String SEND = "Send";

	public static final String SEND_ALSO_AS_EMAIL = "Send also as E-mail";

	public static final String REMOVE_ALL = "Remove all";

	public static final String ADD_ALL = "Add all";

	public static final String CLICK_TO_REMOVE_RECIPIENT = "Click to remove this recipient";

	public static final String ERROR_NO_RECIPIENT_SELECTED = "Select at least one recipient to send message!";

	public static final String MESSAGE_SENT = "Message sent!";

	public static final String SENDER_WROTE = "@0 wrote:";

	public static final String CONTINUE = "Continue";

	public static final String EXPLANATION_VILLE_VISUALIZATION = "Explanation for ViLLE visualization";

	public static final String EXPLANATION_VILLE_SORTING = "Explanation for ViLLE sorting";

	public static final String EXPLANATION_VILLE_QUIZ = "Explanation for ViLLE quiz";

	public static final String EXPLANATION_VILLE_CODING = "Explanation for ViLLE coding";

	public static final String EXPLANATION_VILLE_CAB = "Explanation for ViLLE CAB";

	public static final String EXPLANATION_SURVEY = "Explanation for survey";

	public static final String ADD_CONTACT = "Add as a contact";

	public static final String SEND_MESSAGE = "Send message";

	public static final String CONTACT_ADDED = "Contact added!";

	public static final String PERSONAL_DATA = "Personal data";

	public static final String CATEGORIZE_EXAMPLE = "Categorize the example";

	public static final String THIS_FIELD_IS_REQUIRED = "This field is required";

	public static final String RESET = "Reset";

	public static final String THIS_PROFILE_IS_NOT_PUBLIC = "This profile is set as non-public.";

	public static final String CHANGE_PASSWORD = "Change password";

	public static final String OLD_PASSWORD = "Old password:";

	public static final String NEW_PASSWORD = "New password:";

	public static final String RETYPE_NEW_PASSWORD = "Retype new password:";

	public static final String ERROR_PASSWORD_NOT_LONG_ENOUGH = "Password has to be at least 6 characters long";

	public static final String ERROR_NEW_PASSWORDS_DONT_MATCH = "New passwords don't match!";

	public static final String ERROR_INCORRECT_OLD_PASSWORD = "Incorrect old password!";

	public static final String NOT_AUTHORIZED = "Not authorized!";

	public static final String PASSWORD_CHANGED = "Password changed!";

	public static final String PROFILE_PUBLIC_FOR_OTHER_USERS = "Profile visible to other users:";

	public static final String YES = "Yes";

	public static final String NO = "No";

	public static final String DATE_FORMAT = "Date format";

	public static final String STATISTICS_FOR_ALL_ROUNDS = "Statistics for all rounds";

	public static final String STATISTICS_FOR_ASSIGNMENTS_IN_ROUND = "Statistics for assignments in round @0:";

	public static final String SELECT_ROUND_TO_DISPLAY = "Select round to display";

	public static final String ALL_ROUNDS = "All rounds";

	public static final String EXIT = "Exit";

	public static final String RETURN_TO_COURSE_EXPLORER = "Return to course explorer view...";

	public static final String TOOLTIP_MOVE_TO_ROUND = "Move to another round";

	public static final String MOVE_THIS_ASSIGNMENT_TO = "Move this assignment to:";

	public static final String HIDE_EXAMPLE_QUESTION = "Hide example question";

	public static final String EXERCISE_SAVE_OWN_EXER_ATTACHED_TO_OWN_NO_OTHERS = "Exercise save: own exercise, attached to own, no others";

	public static final String EXERCISE_SAVE_OWN_EXER_ATTACHED_TO_OWN_AND_OTHERS = "Exercise save: own exercise, attached to own and others";

	public static final String UPDATE_ALL_ASSINGMENTS = "Update all assignments";

	public static final String SELECT_FROM_A_LIST = "Select from a list";

	public static final String MINIMUM_SCORE_REQUIRED = "Minimum score required";

	public static final String ROUND_SCORE_AND_MINIMUM_REQUIRED = "Score: @0 / @1, minimum required: @2";

	public static final String COURSE_SCORE_AND_MINIMUM_REQUIRED = "Course total score: @0 / @1, minimum required: @2";

	public static final String ASSIGNMENTS_AND_SUBMISSIONS = "@0 assignments, @1 submissions.";

	public static final String ASSIGNMENT_AND_SUBMISSION = "@0 assignment, @1 submission.";

	public static final String ASSIGNMENTS_AND_SUBMISSION = "@0 assignments, @1 submission.";

	public static final String ASSIGNMENT_AND_SUBMISSIONS = "@0 assignment, @1 submissions.";

	public static final String ERROR_SELECT_PROGRAMMING_LANGUAGE = "Select programming language";

	public static final String SUBMISSION = "submission";

	public static final String MATERIALS_FOR_ASSIGNMENT = "Materials for assignment";

	public static final String MATERIALS_FOR_ROUND = "Materials for round";

	public static final String MATERIALS_FOR_COURSE = "Materials for course";

	public static final String YOU_CAN_NOW_LOGIN_USING_EMAIL_PW = "You can now login using your e-mail address and password.";

	public static final String COURSE_NOT_OPEN_FOR_REGISTRATION = "This course is not open for registration!";

	public static final String YOU_CAN_STILL_DO_ASSIGNMENTS = "You can still do assignments, but submitted answers will not be saved.";

	public static final String ATTACHED_EXERCISE = "Attached exercise";

	public static final String AUTOMATICALLY_ASSESSED = "Automatically assessed";

	public static final String MANUALLY_GRADED = "Manually graded";

	public static final String INCLUDE_EXERCISE = "Include exercise";

	public static final String CLOSES_IN_DAYS_HOURS = "closes in @0 days, @1 hours.";

	public static final String MANUALLY_GRADED_ASSIGNMENTS = "Manually graded assignments";

	public static final String GRADE = "Grade";

	public static final String THIS_IS_MANUALLY_GRADED_ASSIGNMENT = "This is a manually graded assignment, no exercise is attached";

	public static final String THIS_ASSIGNMENT_IS_GRADED_WITH_GRADE = "This assignment is graded.";

	public static final String TEACHERS_COMMENTS = "Teacher's comments:";

	public static final String THIS_TYPE_OF_SUBMISSION_DOESNT_CONTAIN_DATA_BUT_SCORE = "This type of submission does not contain any viewable data besides the score.";

	public static final String SELECT_A_ROLE_TO_START_USING_VILLE = "Select a role to start using ViLLE:";

	public static final String LOGIN_AS_TEACHER = "Log in as a teacher";

	public static final String LOGIN_AS_STUDENT = "Log in as a student";

	public static final String EXPLANATION_FOR_ROLE_TEACHER = "Explanation for role teacher";

	public static final String EXPLANATION_FOR_ROLE_STUDENT = "Explanation for role student";

	public static final String INCLUDE_SELF_IN_COURSE_AS_STUDENT = "Include yourself in the course as student";

	public static final String HELP_FOR_TEACHER_REGISTER_AS_STUDENT = "Help for teacher registrating as student:";

	public static final String MESSAGE_FOR_OLD_PASSWORD_AFTER_PW_RESET = "Message for login with old password after reset";

	public static final String INSERT_COURSE_KEY = "Insert course key";

	public static final String VILLE_CONSTRUCT_VISUALIZATION = "ViLLE Construct visualization";

	public static final String DISTRIBUTE_CONSTRUCT = "ViLLE Distributed construct";

	public static final String VILLE_POOL_EXERCISE = "ViLLE Exercise pool";

	public static final String EXPLANATION_VILLE_CONSTRUCT = "Explanation for ViLLE construct";

	public static final String EXPLANATION_VILLE_EXERCISE_POOL = "Explanation for ViLLE exercise pool";

	public static final String SET_ROUND_DEFAULTS = "Set round defaults";

	public static final String EXPLANATION_ROUND_DEFAULTS = "Round defaults explanation";

	public static final String SET_OPENING_TIMES_FOR_ROUNDS = "Set opening times for all rounds";

	public static final String ROUNDS_OPEN = "Rounds open";

	public static final String SET_CLOSING_TIMES_FOR_ROUNDS = "Set closing times for all rounds";

	public static final String ROUNDS_CLOSE = "Rounds close";

	public static final String SET_ROUNDS_MINIMUM_SCORE = "Set rounds' minimum score required";

	public static final String MINIMUM_SCORE_AS_PERCENT = "Minimum score (as percent of round total maximum score)";

	public static final String SET_VALUES = "Set";

	public static final String SHOW_HAKA_REGISTRATION_LINK = "Show HAKA registration link";

	public static final String HOWEVER_AS_TEACHER_YOU_CAN_TEST_ASSIGNMENTS = "(however, being a teacher, you can still do assignments and submit answers)";

	public static final String TEST_ASSIGNMENT = "Test assignment";

	public static final String LIKE = "like";

	public static final String DISLIKE = "dislike";

	public static final String PERCENTAGE_WHO_LIKES_THIS = "@0 of @1 (@2%) likes this.";

	public static final String SCALE_LEFT_TITLE = "Scale left title (optional)";

	public static final String SCALE_RIGHT_TITLE = "Scale right title (optional)";

	public static final String OPTIONS_WITH_TEXTAREA = "Options with text area";

	public static final String OPTIONS_WITH_TEXTAREA_EXPLANATION = "Add an option list with alternative text area.";

	public static final String TITLE_FOR_ALTERNATIVE_CHOICE = "Title for alternative choice";

	public static final String OTHER_PLEASE_SPECIFY = "Other, please specify:";

	public static final String ERROR_TOO_MANY_MATERIALS_ATTACHED = "Error too many materials attached";

	public static final String ASSISTANT_TEACHERS = "Assistant teachers";

	public static final String EXPLANATION_FOR_ASSISTANT_TEACHERS = "Assistant teachers explanation";

	public static final String CONFIRM_TEACHER_REMOVAL_FROM_COURSE = "Remove assistant teacher @0 from course?";

	public static final String SELECT_TEACHER_TO_REMOVE = "Select a teacher to remove!";

	public static final String ADD_ASSISTANT_TEACHER = "Add assistant teacher";

	public static final String TEACHERS_USER_ID = "Teacher's user id:";

	public static final String ERROR_NO_TEACHER_WITH_USER_ID = "There is no teacher with user id provided.";

	public static final String ASSISTANT_TEACHER_ADDED = "Assistant teacher added!";

	public static final String ANIMATION_CONTROLS = "Animation controls";

	public static final String ATTACHED = "Attached";

	public static final String CALL_STACK = "Call stack";

	public static final String ERROR_COULD_NOT_COMPILE = "Program couldn't be compiled";

	public static final String ERROR_EXECUTION_TIMEOUT = "Execution timeout";

	public static final String ERROR_IN_PROGRAM_CODE = "There's an error in your program code!";

	public static final String ERROR_IN_PROGRAM_EXECUTION = "Error in program execution";

	public static final String ERROR_IN_IO = "Error in IO";

	public static final String EXACT_MATCH = "Exact match";

	public static final String EXECUTION_STOPPED_AT_LINE = "Execution stopped at line @0.";

	public static final String EXPLANATION_2D_ARRAY_CREATE = "Two-dimensional array @0 is created. The size of array is @1 x @2 cells.";

	public static final String EXPLANATION_2D_ARRAY_VALUE_CHANGE = "The value of cell [@0,@1] in array @2 is changed to @3.";

	public static final String EXPLANATION_AND = "and";

	public static final String EXPLANATION_ARRAY_CREATE = "Array @0 is created. The size of array is @1.";

	public static final String EXPLANATION_ARRAY_REFERENCE_CHANGE = "Array @0 is set to point to array @1.";

	public static final String EXPLANATION_ARRAY_VALUE_CHANGE = "The value of cell @0 in array @1 is changed to @2.";

	public static final String EXPLANATION_BLOCK_NOT_EXECUTED = "The block is not executed.";

	public static final String EXPLANATION_BREAK = "Exit current loop.";

	public static final String EXPLANATION_CLASS_DEF_ENDS = "Class definition ends.";

	public static final String EXPLANATION_CLASS_INIT = "Define class @0.";

	public static final String EXPLANATION_PUBLIC_CLASS_INIT = "Define public class @0.";

	public static final String EXPLANATION_COMMENT = "Comment. Doesn't affect program execution.";

	public static final String EXPLANATION_COMMENT_BLOCK_BEGIN = "Comment block begins. Doesn't affect program execution.";

	public static final String EXPLANATION_COMMENT_BLOCK_END = "Comment block ends. Doesn't affect program execution.";

	public static final String EXPLANATION_CONSTRUCTOR_DEF = "Defining class's @0 constructor, with parameter @1.";

	public static final String EXPLANATION_CONSTRUCTOR_ENDS = "Constructor ends.";

	public static final String EXPLANATION_CONTINUE = "Continue loop execution from the beginning of the current loop.";

	public static final String EXPLANATION_DEFINE_PRIVATE_PROCEDURE = "Define private procedure @0 with parameter @1.";

	public static final String EXPLANATION_DO_WHILE = "Do-while loop. Condition @0 is @1.";

	public static final String EXPLANATION_DO_WHILE_INIT = "Do-while loop initialized.";

	public static final String EXPLANATION_ELSE_ENDS = "Else-block ends.";

	public static final String EXPLANATION_ELSE_EXECUTED = "Block that is executed, if earlier if-loops condition were false.";

	public static final String EXPLANATION_ELSE_IF_ENDS = "Else-if block ends.";

	public static final String EXPLANATION_EXECUTION_CONTINUES_INSIDE_BLOCK = "Execution continues inside the block.";

	public static final String EXPLANATION_EXECUTION_CONTINUES_INSIDE_ELSE = "Execution continues inside else block.";

	public static final String EXPLANATION_FOR_ENDS = "For loop ends.";

	public static final String EXPLANATION_FOR_ROTATES = "For loop rotates. Condition @0 is @1.";

	public static final String EXPLANATION_FUNCTION_ENDS = "Function ends.";

	public static final String EXPLANATION_IF = "Conditional statement. Condition @0 is @1.";

	public static final String EXPLANATION_IF_ENDS = "If-block ends.";

	public static final String EXPLANATION_IS_EQUAL = "is equal to";

	public static final String EXPLANATION_IS_NOT = "is not";

	public static final String EXPLANATION_MAIN_BEGINS = "The execution of main program begins.";

	public static final String EXPLANATION_MAIN_ENDS = "Main program ends.";

	public static final String EXPLANATION_METHOD_CALL = "Method call @0.";

	public static final String EXPLANATION_METHOD_ENDS = "Method ends.";

	public static final String EXPLANATION_METHOD_INIT = "Initializing method @1. Method parameters are @2 and it returns variable with type @0.";

	public static final String EXPLANATION_OUTPUT = "Output @0.";

	public static final String EXPLANATION_PRESENT_VARIABLE = "Variable @0 is presented, but not initialized.";

	public static final String EXPLANATION_PRIVATE_CLASS_INIT = "Define private class @0.";

	public static final String EXPLANATION_PRIVATE_METHOD_INIT = "Initializing private method @1. Method parameters are @2 and it returns variable with type @0.";

	public static final String EXPLANATION_RETURN = "Return @0.";

	public static final String EXPLANATION_STATIC_METHOD_ENDS = "Static method ends.";

	public static final String EXPLANATION_STATIC_PROCEDURE_INIT = "Initializing static method @0. Method parameters are @1.";

	public static final String EXPLANATION_SWITCH_BEGINS = "Switch statement begins, with parameter @0.";

	public static final String EXPLANATION_SWITCH_ENDS = "Switch statement ends.";

	public static final String EXPLANATION_VARIABLE_CHANGE = "The value of variable @0 is changed to @1.";

	public static final String EXPLANATION_VARIABLE_INIT = "Initializing variable @0.";

	public static final String EXPLANATION_VARIABLE_INIT_WITH_VALUE = "Initializing variable @0 with value @1.";

	public static final String EXPLANATION_WHILE = "While loop. Condition @0 is @1.";

	public static final String EXPLANATION_WHILE_ENDS = "While loop ends.";

	public static final String FALSE = "false";

	public static final String FROM = "From";

	public static final String INCORRECT = "Incorrect!";

	public static final String LOCAL_VARIABLES = "Local variables";

	public static final String OUTPUT = "Output";

	public static final String PROGRAM_OUTPUT = "Program output";

	public static final String PROGRAM_TRANSLATED_SUCCESSFULLY = "Program translated successfully.";

	public static final String RETURN_VALUE = "Return value";

	public static final String SELECT_SORTED_CODE_LINES = "Select code lines to be sorted";

	public static final String SHARED_MEMORY = "Shared memory";

	public static final String SORT_CODE_LINES = "Sort code lines";

	public static final String TEST = "Test";

	public static final String TO = "To";

	public static final String TOOLTIP_DUAL_VIEW = "Compare program code in two different languages";

	public static final String TOOLTIP_MOVE_TO_NEXT = "Move to next program line";

	public static final String TOOLTIP_MOVE_TO_PREVIOUS = "Move to previous program line";

	public static final String TOOLTIP_MOVE_TO_START = "Move to the beginning of the program";

	public static final String TRANSLATE = "Translate";

	public static final String TRANSLATION_STOPPED_AT_LINE = "Translation stopped at line @0.";

	public static final String TRUE = "true";

	public static final String VARIABLE_STATES = "Variable states";

	public static final String VISUALIZATION = "Visualization";

	public static final String INSERT_TO_ARRAY = "Insert correct value to array";

	public static final String CREATE_MULTI_CHOICE = "Create multiple choice questions";

	public static final String SELECT_LINES_CODING = "Select lines to be coded";

	public static final String DETACH = "Detach";

	public static final String PARALLEL_VIEW = "Parallel View";

	public static final String QUESTIONS_ANSWERED = "Questions answered";

	public static final String NEXT_QUESTION = "Next question";

	public static final String CODING_AREA = "Coding area";

	public static final String ADD_QUESTION = "Add question";

	public static final String DELETE_QUESTION = "Delete question";

	public static final String EDIT_QUESTION = "Edit question";

	public static final String SELECT_QUESTION = "Select question";

	public static final String SUBMIT_ANSWERS = "Submit answers?";

	public static final String NEXT = "Next";

	public static final String PREVIOUS = "Previous";

	public static final String SAVE_AND_CLOSE = "Save & Close";

	public static final String MULTIPLE = "Multiple";

	public static final String ARRAY = "Array";

	public static final String NEW_MULTIPLE_CHOICE_QUESTION = "New multiple choice question";

	public static final String NEW_ARRAY_QUESTION = "New array question";

	public static final String TOOLTIP_VIEW_CALLSTACK = "View the callstack of subprogram calls";

	public static final String TOOLTIP_VIEW_VARIABLES = "View the states of all variables";

	public static final String WRITE_AND_TRANSLATE_PROGRAM = "Write and translate program code";

	public static final String EDIT_TRANSLATIONS = "Edit translations";

	public static final String EDIT_QUESTIONS = "Edit questions";

	public static final String EDIT_EXERCISE = "Edit exercise";

	public static final String NAME_AND_DESCRIPTION = "Name and description";

	public static final String ADD_NEW_VARIABLE = "Add new variable to the program";

	public static final String OTHER_CHOICES = "Other choices";

	public static final String NEW_VARIABLE = "New variable";

	public static final String CREATE_SUBPROGRAM = "Create subprogram";

	public static final String REMOVE_FROM_CALLSTACK = "Remove from stack";

	public static final String BASIC_VARIABLE = "Basic variable";

	public static final String ARRAY_VARIABLE = "Array variable";

	public static final String STRING_VARIABLE = "String variable";

	public static final String VALUE = "Value";

	public static final String INITIALIZE_NEW = "Initialize new";

	public static final String ROWS = "Rows";

	public static final String COLS = "Cols";

	public static final String REFERENCE = "Reference";

	public static final String MODIFY_VARIABLE = "Modify variable";

	public static final String NO_HIGHLIGHT = "No code line highlight";

	public static final String HIGHLIGHT = "With code lines highlighted";

	public static final String COMPLETE_STATES = "Complete each state before continuing";

	public static final String SUBPROGRAM_NAME = "Subprogram name";

	public static final String PARAMETER_COUNT = "Parameter count";

	public static final String EXPLANATION_CAB_EDITOR = "Explanation CAB editor";

	public static final String EXPLANATION_TRANSLATION_STEP = "Explanation translation step";

	public static final String EXPLANATION_TRANSLATION_STEP_SORTING = "Explanation translation step sorting";

	public static final String EXPLANATION_TRANSLATION_STEP_CODING = "Explanation translation step coding";

	public static final String EXPLANATION_EDIT_TRANSLATION_STEP = "Explanation edit translations step";

	public static final String EXPLANATION_INFO_STEP = "Explanation info step";

	public static final String EXPLANATION_VISUALIZATION_EDITOR = "Explanation visualization editor";

	public static final String EXPLANATION_SORTING_EDITOR = "Explanation sorting editor";

	public static final String EXPLANATION_QUIZ_EDITOR = "Explanation quiz editor";

	public static final String EXPLANATION_CODING_EDITOR = "Explanation coding editor";

	public static final String CHOICE = "Choice";

	public static final String IDENTIFIER = "Identifier";

	public static final String CREATE = "Create";

	public static final String NEW_BASIC_VAR = "New basic variable";

	public static final String NEW_ARRAY_VAR = "New array variable";

	public static final String NEW_STRING_VAR = "New string variable";

	public static final String STATE_CONTROL = "State control";

	public static final String ERROR_CORRECT_MUST_BE_UNIQUE = "Correct choice has to be unique";

	public static final String WOULD_YOU_LIKE_TO_VISUALIZE = "Would you like to visualize the exercise?";

	public static final String ERROR_STATE_INCORRECT = "Current state is incorrect";

	public static final String TOOLTIP_MOVE_TO_NEXT_QUESTION = "Move to the next question";

	public static final String CORRECT_OUTPUT = "Correct output";

	public static final String OUTPUT_COMPARISON = "Output comparison";

	public static final String EXECUTION_TIMEOUT = "Execution timeout";

	public static final String SELECT_POOL_TYPE = "Select pool type";

	public static final String POOL_RANDOM_EXERCISE = "Random select";

	public static final String POOL_USER_SELECT_EXERCISE = "User select";

	public static final String POOL_CUSTOM_EXERCISE = "Custom";

	public static final String SELECT_POOL = "Select pool";

	public static final String SELECT_EXERCISE = "Select exercise";

	public static final String SELECT = "Select";

	public static final String RATE_EXERCISE = "Rate exercise";

	public static final String ERROR_YOU_MUST_RATE = "You must rate this exercise before submit!";

	public static final String SHOW_OUTPUT = "Show output";

	public static final String EMBEDDED_IMAGE = "Embedded image";

	public static final String DELETE_IMAGE = "Delete image";

	public static final String ATTACHED_TEXT = "Attached text";

	public static final String INCLUDED_EXERCISE_TYPES = "Included exercise types";

	public static final String MIN_NUMBER_OF_QUESTIONS_REQ = "Minimum number of questions required";

	public static final String INCLUDE_AT_LEAST = "Include at least one exercise type!";

	public static final String YOU_MUST_GIVE_NAME = "You must give this exercise a name!";

	public static final String PUBLIC = "Public";

	public static final String PRIVATE = "Private";

	public static final String EXERCISE_VISIBILITY = "Exercise visibility";

	public static final String START = "Start";

	public static final String HIDE_OTHER_CODE_LINES = "Hide nonselected code lines";

	public static final String LENGTH = "Length";

	public static final String ERROR_SELECT_CONTACTS_FIRST = "Select a contact first!";

	public static final String BY = "by";

	public static final String VIEW_AS_TABLE = "View as table";

	public static final String VIEW_AS_THUMBS = "View as thumbnails";

	public static final String VIEW_AS_LIST = "View as list";

	public static final String COURSE_KEY_MISSING = "Course key is missing";

	public static final String HELP = "Help";

	public static final String MINIMIZE = "Minimize";

	public static final String RESTORE = "Restore";

	public static final String DESCRIPTION_ADD_COURSE_TAGS = "Description add course tags";

	public static final String FILTER = "Filter";

	public static final String ANY_SELECTION = "Selection_any";

	public static final String UPDATE = "Update";

	public static final String ANY_TYPE = "Any type";

	public static final String ANY_DIFFICULTY = "Any difficulty";

	public static final String ANY_PROGRAMMING_LANGUAGE = "Any prog. language";

	public static final String ANY_LANGUAGE = "Any language";

	public static final String ACTIONS = "Actions";

	public static final String COPY = "Copy";

	public static final String SELECT_COURSE_TO_INSERT_ROUND_INTO = "Select a course to insert the selected round into:";

	public static final String ROUND_ADDED = "Round added!";

	public static final String SELECT_ROUND_FIRST = "Select a round first!";

	public static final String GENERAL_SORTING = "General sorting";

	public static final String EXPLANATION_GENERAL_SORTING = "Explanation for general sorting";

	public static final String ROUND_IS_HIDDEN = "Round is hidden";

	public static final String ROUND_IS_VISIBLE = "Round is visible";

	public static final String CLICK_TO_TOGGLE_VISIBILITY = "Click to toggle visibility!";

	public static final String SHORT_ANSWER = "Short answer";

	public static final String NEW_SHORT_ANSWER = "New short answer";

	public static final String ANSWER_CASE_SENSITIVE = "Answer case sensitive";

	public static final String RESULT_SUBMITTED = "Result submitted";

	public static final String SELECT_ROUND_TYPE = "Select round type:";

	public static final String NORMAL_ROUND = "Normal round";

	public static final String EXAM_ROUND = "Exam round";

	public static final String EXAM_SETTINGS = "Exam settings";

	public static final String GENERAL_SETTINGS = "General settings";

	public static final String INCLUDE_TO_COURSE_TOTAL_SCORE = "Include to course total score";

	public static final String SHOW_USERS_PREVIOUS_ANSWERS_IN_ASSIGNMENTS = "Show user's previous answers in assignments";

	public static final String SHOW_SUBMISSION_SCORE_AND_FEEDBACK = "Show submission score and feedback to student";

	public static final String SETTINGS_FOR_VISUALIZATION = "Settings for visualization assignments";

	public static final String SHOW_VARIABLES = "Show variables";

	public static final String SHOW_EXPLANATIONS = "Show code line explanations";

	public static final String SETTINGS_FOR_SORTING = "Settings for sorting assignments";

	public static final String INDENT_CODE_LINES = "Indent code lines";

	public static final String ALLOW_CODE_VISUALIZATION_AFTER_SORTING = "Allow code visualization after sorting";

	public static final String TIME_ZONE = "Time zone";

	public static final String SERVER_TIME_NOW = "Server time now";

	public static final String LAST_SUBMISSION = "Last submission";

	public static final String SETTINGS_FOR_QUIZZES = "Settings for quiz assignments";

	public static final String SHOW_QUIZ_QUESTIONS_IN_RANDOM_ORDER = "Show quiz questions in random order";

	public static final String EXAM_NOT_INCLUDED_IN_COURSE_TOTALS = "Exam round not included in the course totals";

	public static final String VIEW_SUBMISSIONS = "View submissions";

	public static final String PREVIOUSLY_SELECTED_ANSWER = "Previously selected answer";

	public static final String ERROR = "Error";

	public static final String DESCRIPTION_VIEW_SUBMISSIONS = "Description for View submissions";

	public static final String SELECT_STUDENT_AND_ASSIGNMENT = "Select student and assignment to view submission";

	public static final String LAST_SUBMISSION_SCORE = "Last submission score";

	public static final String CORRECT_CODE = "Correct code";

	public static final String STUDENTS_SUBMISSION = "Student's submission";

	public static final String SUBMISSION_OUTPUT = "Submission output";

	public static final String STUDENTS_ASSESS_ASSIGNMENT = "Students assess assignment difficulty";

	public static final String ASSIGNMENT_DIFFICULTY = "Assignment difficulty";

	public static final String EMAIL = "Email";

	public static final String STUDENT_ID = "Student id";

	public static final String ENTER_NEW_SCORE_FOR_SUBMISSION = "Enter new score for the submission";

	public static final String NEW_SCORE = "New score";

	public static final String ANSWER = "Answer";

	public static final String ERROR_NO_TERM_FOR_STUDENT_SEARCH = "Error no search term for student search";

	public static final String VISIBLE_TO_STUDENTS = "Visible to students";

	public static final String HIDDEN_FROM_STUDENTS = "Hidden from students";

	public static final String SELECT_ALL = "Select all";

	public static final String CLEAR_SELECTION = "Clear selection";

	public static final String ERROR_NO_USER_OR_ASSIGNMENT_SELECTED_FOR_EXPORT = "Error no student or assignment selected for export";

	public static final String EXPAND_SHRINK_DESCRIPTION = "Expand / shrink assignment description area";

	public static final String OPEN_ASSIGNMENT_DESCRIPTION_WINDOW = "Open assignment description in new window";

	public static final String PERSONAL_DEADLINES = "Personal deadlines";

	public static final String ADD_DEADLINE = "Add deadline";

	public static final String EXPLANATION_FOR_PERSONAL_DEADLINES = "Explantion for personal deadlines";

	public static final String DEADLINE = "Deadline";

	public static final String CHECK = "Check";

	public static final String CHECK_INFINITE_LOOP = "Check for infinite or recursively infinite loops";

	public static final String FOUND_USER = "Found user:";

	public static final String ERROR_NO_SUCH_USER_IN_YOUR_COURSES = "No such user found in any of your courses!";

	public static final String ERROR_FOR_OWN_PERSONAL_DEADLINE = "Error for own personal deadline";
	public static final String ERROR_FOR_OWN_PERSONAL_DEADLINE_DESC = "As a course owner, you can always view all rounds - open or closed";

	public static final String SHOW_BEST_SUBMISSION_NOT_LAST = "Students see the best submission instead of the last";

	public static final String EXAM_IS_CLOSED = "Exam is closed";

	public static final String YOU_CAN_VIEW_YOUR_SUBMISSIONS = "You can view your submissions by clicking the assignment name";

	public static final String NO_SUBMISSIONS = "You have not submitted any answers to this assignment.";

	public static final String NUMBER_OF_PEOPLE_WHO_LIKE_THIS = "@0 of @1 likes this.";

	public static final String RATING_LIKES = "Rating (likes)";

	public static final String PERCENT_NUMBER_OF_NUMBER = "@0% (@1 of @2)";

	public static final String COURSES_BY_USER = "Courses by @0";

	public static final String EXERCISES_BY_USER = "Exercises by @0";

	public static final String MATERIALS_BY_USER = "Materials by @0";

	public static final String VIEW_ALL = "View all";

	public static final String USERS_REGISTERED = "Users registered";

	public static final String COURSE_PROPERTIES = "Course properties";

	public static final String COURSE_COPIED = "Course copied!";

	public static final String COURSE_COPIED_SUBTEXT = "Course copied subtext";

	public static final String NEW = "New";

	public static final String VIEW_RESOURCES = "View resources";

	public static final String MENU_ITEM_TUTORIALS = "Menu Item Tutorials";

	public static final String AMENU_AUTOMATIC = "AMenu Automatically assessed";

	public static final String AMENU_MANUAL = "AMenu Manually graded";

	public static final String AMENU_CONSTRUCT = "AMenu Construct assignment";

	public static final String AMENU_POOL = "AMenu Exercise pool";

	public static final String AMENU_UPLOAD = "AMenu Assignment submissions";

	public static final String AMENU_AUTOMATIC_DESCRIPTION = "AMenu automatic description";

	public static final String AMENU_MANUAL_DESCRIPTION = "AMenu manual description";

	public static final String AMENU_CONSTRUCT_DESCRIPTION = "AMenu construct description";

	public static final String AMENU_POOL_DESCRIPTION = "AMenu pool description";

	public static final String AMENU_UPLOAD_DESCRIPTION = "AMenu submission description";

	public static final String ABBREVIATION_MAX_POINTS = "Abbreviation max points";

	public static final String EDIT_DESCRIPTION = "Edit description";

	public static final String UPDATE_EXERCISE_DESCRIPTION_TOO = "Update exercise description also";

	public static final String UPDATE_EXERCISE_DESCRIPTION_TOOLTIP = "Update exercise description tooltip";

	public static final String INCLUDE_AUTOMATICALLY_ASSESSED_EXERCISE = "Include automatically assessed exercise";

	public static final String ERROR_FOR_NAME_OR_POINTS_MISSING = "Error for name or points missing";

	public static final String YOU_CANT_EDIT_THIS_TYPE_EXERCISE = "You cant edit this type of exercise!";

	public static final String ASSIGNMENT_TITLE = "Assignment title";

	public static final String QUICK_CHART_DESCRIPTION = "Visual representations from the current view";

	public static final String SPLINE = "Spline";

	public static final String COLUMNS = "Columns";

	public static final String SELECT_DATA = "Select data";

	public static final String SELECT_EVENTS = "Select events";

	public static final String PERFORMANCE_VISUALIZATION = "Performance visualization";

	public static final String PRESENTATION_METHOD = "Presentation method";

	public static final String IN_MINUTES = "in minutes";

	public static final String NO_CHART_DATA = "Current table view dosn't contain enough data";

	public static final String SPLINE_LINE = "Lines";

	public static final String SPLINE_POINTS = "Points";

	public static final String TABLE_ORDER = "Table order";

	public static final String MAGNITUDE_ORDER = "Magnitude order";

	public static final String SORTING_METHOD = "Sorting method";

	public static final String DOWNLOAD_CHART_IMAGE = "Download an image containing the current chart view";

	public static final String AVERAGE = "Average";

	public static final String PAGE = "Page";

	public static final String MONTHS = "Month(s)";

	public static final String DAYS = "Day(s)";

	public static final String HOURS = "Hour(s)";

	public static final String DATA_TIME_PERIOD = "Data time period";

	public static final String PANEL = "Panel";

	public static final String WITH_STANDARD_DEVIATION = "With st. dev.";

	public static final String MAXIMUM = "Maximum";

	public static final String MINIMUM = "Minimum";

	public static final String MEDIAN = "Median";

	public static final String INTERVAL_TOTAL = "Interval total";

	public static final String AVERAGE_TIME_USED_PER_STUDENT = "Average time used per student";

	public static final String MINS = "Min(s)";

	public static final String PLEASE_PRESS_THE_SUBMIT_BUTTON = "Please press the button in order to generate the chart image";

	public static final String NO_COURSE_DATA = "No course data";

	public static final String NO_ROUND_DATA = "No round data";

	public static final String STATISTICS_PANEL = "Statistics panel";

	public static final String SUBMISSION_COUNT = "Submission count";

	public static final String AVG_TIME_PER_SUBMISSION = "Avg. time taken per submission";

	public static final String ACTIVE = "Active";

	public static final String PASSIVE = "Passive";

	public static final String PASSED = "Passed";

	public static final String NOT_YET_PASSED = "Non-passed";

	public static final String MIN = "Min";

	public static final String MAX = "Max";

	public static final String SUBM = "n";

	public static final String SUBM_EXPLANATION = "Number of submissions during the interval";

	public static final String CHART_IMAGE = "Chart image";

	public static final String URL_TOO_LONG = "Url too long";

	public static final String TODAY = "Today";

	public static final String LAST_THREE_DAYS = "Last three days";

	public static final String LAST_WEEK = "Last week";

	public static final String LAST_TWO_WEEKS = "Last two weeks";

	public static final String LAST_MONTH = "Last month";

	public static final String SINCE_BEGINNING = "Since beginnning";

	public static final String INTERVAL_SELECT_TOOLTIP = "You can also insert an arbitrary number of days as interval (1-1000)";

	public static final String INTERVAL_SELECT_ERROR = "Must be an integer ( 1 - 1000)";

	public static final String REPORT_ON_ALL_COURSES = "Report on all courses";

	public static final String REPORT_ON_CLOSING_ROUNDS = "Report on closing rounds";

	public static final String REPORT_ON_COURSE = "Report on course";

	public static final String REPORT_BUTTON_TOOLTIP = "Printable statistics report about all courses for chosen interval";

	public static final String ACTIONS_IN_COURSES = "Actions in courses";

	public static final String ACTIONS_IN_LAST_DAYS = "Actions in last @0 days";

	public static final String ACTIONS_IN_LAST_WEEKS = "Actions in last @0 weeks";

	public static final String NO_ACTIVITY_IN_THE_INTERVAL = "No activity in the interval";

	public static final String ACHIEVED_OF_MAXIMUM_POINTS_ON_AVERAGE = "Of maximum points on average";

	public static final String ACHIEVED_OF_MAXIMUM_POINTS_ON_AVERAGE_DESCRIPTION = "Score of student's best submission / maximum score on average.";

	public static final String AVERAGE_SCORE_PERCENTAGE_DESCRIPTION = "Submission score / exercise maximum points on average.";

	public static final String GREETINGS_FROM_COURSE = "Greetings from course";

	public static final String IN_LAST_DAYS = "In last @0 days";

	public static final String STUDENT_ACTIVITY = "Student activity";

	public static final String SHOW_INFO_ON_ROUNDS = "Show info on rounds";

	public static final String NO_LIMIT = "No limit";

	public static final String DEADLINE_COMING_ON_COURSE = "Deadline coming on course";

	public static final String DEADLINE_OF_ROUND_OF_COURSE_COMING_ON = "Deadline of round @0 of course @1 coming on @2";

	public static final String ROUNDS_CLOSING_SOON = "Rounds closing soon";

	public static final String ROUNDS_NOT_CLOSING_SOON = "Rounds not closing soon";

	public static final String SEND_MASS_MESSAGE = "Send mass message";

	public static final String TIME_TOTAL = "Time (total)";

	public static final String TIME_INTERVAL = "Time (interval)";

	public static final String AVERAGE_TOTAL = "Average (total)";

	public static final String AVERAGE_INTERVAL = "Average (interval)";

	public static final String SUBMISSIONS_TOTAL = "Submissions (total)";

	public static final String SUBMISSIONS_INTERVAL = "Submissions (interval)";

	public static final String OF_MAXIMUM = "Of maximum";

	public static final String TOTAL_SCORE = "Total score";

	public static final String FILTER_BY_SCORE = "Filter by score";

	public static final String NO_FILTER = "No filter";

	public static final String MORE_THAN_PERCENT_OF_MAXIMUM = "More than X percent of maximum score";

	public static final String LESS_THAN_PERCENT_OF_MAXIMUM = "Less than X percent of maximum score";

	public static final String BELONGS_TO_BEST_PERCENT = "Belongs to X best percent";

	public static final String BELONGS_TO_WORST_PERCENT = "Belongs to X worst percent";

	public static final String MORE_THAN_POINTS = "More than X points";

	public static final String LESS_THAN_POINTS = "Less than X points";

	public static final String MUST_BE_POSITIVE_INTEGER = "Must be a positive integer";

	public static final String FILTER_BY_ACTIVITY = "Filter by activity";

	public static final String MORE_THAN_SUBMISSIONS_IN_INTERVAL = "More than X submissions in interval";

	public static final String LESS_THAN_SUBMISSIONS_IN_INTERVAL = "Less than X submissions in interval";

	public static final String ACTIONS_IN_INTERVAL = "Actions in interval";

	public static final String NO_ACTIONS_IN_INTERVAL = "No actions in interval";

	public static final String NO_ACTIONS_EVER = "No actions ever";

	public static final String X_PER_Y_STUDENTS_MATHC_FILTER = "@0 / @1 of students match current filters";

	public static final String SHOWING_EVERYTHING_UP_UNTIL = "Showing everything up until @0";

	public static final String WITH_DATA_FROM_INTERVAL = "containing only the data from the selected interval";

	public static final String REPORT_CHART_DEFAULT_X_AXIS_INFO = "Individual exercises are marked with numbers on the X-axis";

	public static final String MAX_PTS = "Max pts";

	public static final String MIN_PTS = "Min pts";

	public static final String SCORE_INCREASE_IN_INTERVAL = "Score increase in interval";

	public static final String SCORE_INCREASE_IN_INTERVAL_MORE_THAN_X = "Score increase in interval more than X";

	public static final String SCORE_INCREASE_IN_INTERVAL_LESS_THAN_X = "Score increase in interval less than X";

	public static final String UPLOAD_A_PROFILE_PICTURE = "Upload a profile picture";

	public static final String REMOVE_YOUR_PROFILE_PICTURE = "Remove your profile picture";

	public static final String PICTURE_DELETED_SUCCESFULLY = "Picture deleted succesfully";

	public static final String PICTURE_IS_IN_UNSOPPORTED_FORMAT = "File is in usupported format (supported formats: jpg, png or gif)";

	public static final String PICTURE_UPLOADED_SUCCESFULLY = "Picture uploaded succesfully";

	public static final String PDF_REPORT = "PDF report";

	public static final String THIS_MIGHT_TAKE_A_WHILE = "This might take a while...";

	public static final String AS_PDF = "As PDF";

	public static final String GENERAL_REPORT = "General report";

	public static final String CLOSING_ROUNDS = "Closing rounds";

	public static final String PER_STUDENT = "Per student";

	public static final String TEACHER_LIST_DESCRIPTION = "Teacher list description";

	public static final String COMPETE = "Compete";

	public static final String TIME_TRIAL = "Time trial";

	public static final String LIBRARY = "Library";

	public static final String TEXT = "Text";

	public static final String IMAGE = "Image";

	public static final String AUDIO = "Audio";

	public static final String MOVIE = "Movie";

	public static final String OBJECT = "Object";

	public static final String EDIT_TEXT_RESOURCE = "Edit text resource";

	public static final String ERROR_SELECT_RESOURCE_FIRST = "Select a resource first!";

	public static final String MESSAGE_CONFIRM_RESOURCE_DELETE = "Are you sure you want to delete this resource?";

	public static final String CONFIRM_RESOURCE_DELETE = "Confirm resource delete";

	public static final String RESOURCES = "Resources";

	public static final String NEW_TUTORIAL = "New tutorial";

	public static final String ADD_SECTION = "Add section";

	public static final String SINGLE = "Single";

	public static final String DOUBLE = "Double";

	public static final String TRIPLE = "Triple";

	public static final String TWO_BY_TWO = "2 by 2";

	public static final String THREE_BY_THREE = "3 by 3";

	public static final String HEADER = "Header";

	public static final String STYLE_SETTINGS = "Style settings";

	public static final String COLORS = "Colors";

	public static final String BACKGROUND = "Background";

	public static final String FONT = "Font";

	public static final String FONT_FAMILY = "Font family";

	public static final String FONT_SIZE = "Font size";

	public static final String BOLDED = "Bolded";

	public static final String ITALIC = "Italic";

	public static final String PADDING = "Padding";

	public static final String MARGIN = "Margin";

	public static final String SYMMETRIC = "Symmetric";

	public static final String TOP = "Top";

	public static final String BOTTOM = "Bottom";

	public static final String LEFT = "Left";

	public static final String RIGHT = "Right";

	public static final String TRANSPARENT = "Transparent";

	public static final String BORDER = "Border";

	public static final String WIDTH = "Width";

	public static final String STYLE = "Style";

	public static final String COLOR = "Color";

	public static final String ROUNDING = "Rounding";

	public static final String NO_BORDER = "No border";

	public static final String SOLID_BORDER = "Solid border";

	public static final String DOTTED_BORDER = "Dotted border";

	public static final String PIXELS = "Pixels";

	public static final String INVALID_VALUE_IN_NUMBER_FIELDS = "Invalid value in one of the number fields!";

	public static final String ADD_CONTENT = "Add content";

	public static final String SECTION_NUMBER = "Section @0";

	public static final String FROM_LIBRARY = "From library";

	public static final String SEND_DEADLINE_RAPORT_MAIL = "Send a weekly raport on courses with upcoming deadlines";

	public static final String PRESETS = "Presets";

	public static final String SAVE_PRESETS = "Save new presets";

	public static final String RESET_SETTINGS = "Reset settings";

	public static final String IP_FILTERS = "IP-filters";

	public static final String NOT_ALLOWED_TO_SUBMIT = "You are not allowed to submit answers from ip-address";

	public static final String NOT_ALLOWED_TO_REGISTER = "You are not allowed to register from ip-address";

	public static final String NOT_ALLOWED_TO_ENTER_ROUND = "You are not allowed to enter the round from ip-address";

	public static final String END_COURSE = "End course";

	public static final String RESTART_COURSE = "Restart course";

	public static final String END_COURSE_DESCRIPTION = "End course description";

	public static final String ROUNDS_STILL_AVAILABLE = "Rounds still available";

	public static final String SHOW_STUDENTS_GRADES = "Show students' grades";

	public static final String GRADE_SCALE = "Grade scale";

	public static final String COURSE_ENDED = "Course ended!";

	public static final String COURSE_RESTARTED = "Course restarted!";

	public static final String VALIDATION_ERROR_INTEGER = "Validation error integer";

	public static final String VALIDATION_ERROR_DOUBLE = "Validation error double";

	public static final String VALIDATION_ERROR_STRING_TOO_LONG = "Validation error string length";

	public static final String SHOW_SUBMISSION_SCORE = "Show submission score to student";

	public static final String ERROR_PLEASE_SELECT_EXERCISE_TYPE = "Please select exercise type";

	public static final String DISTRIBUTE = "Distribute";

	public static final String EXPLANATION_PRIVATE_PUBLIC = "Explanation private public";

	public static final String AMENU_PEER = "Peer-reviewed";

	public static final String PEER_SELECT_ASSIGNMENT = "Please select assignment for peer-review";

	public static final String PEER_SELECT_USER = "Please select user to review";

	public static final String AMENU_PEER_DESCRIPTION = "Create new peer-reviewed assignment";

	public static final String ROBOT_EXERCISE = "Robot exercise";

	public static final String PREVIOUS_ANSWER_UNDERLINED = "Previous answer underlined";

	public static final String SHOW_HELP = "Show help";

	public static final String REVIEW = "Review";

	public static final String PEER_NO_SUBMISSIONS = "No submissions available!";

	public static final String OK_AND_VISUALIZE = "OK and visualize";

	public static final String EMBED_VIDEO = "Embed video";

	public static final String EMBED_VIDEO_DESCRIPTION = "Embed video description";

	public static final String VIDEO_URL = "Video URL";

	public static final String INVALID_VIDEO_URL = "Invalid video URL!";

	public static final String EVALUATE_ASSIGNMENT = "Evaluate assignment";

	public static final String RESULT = "Result";

	public static final String REVIEWS = "Reviews";

	public static final String ERROR_NOT_REGISTERED_TO_ANY_COURSE = "You are not registered to any course!";

	public static final String ADDITIONAL_SETTINGS = "Additional settings";

	public static final String ERROR_CANT_EDIT_TEACHERS_PROPERTIES = "You can't edit properties of a user with teacher account!";

	public static final String ADD_STUDENT = "Add student";

	public static final String ADD_SELECTED_STUDENT = "Add selected student";

	public static final String ADD_NEW_STUDENT = "Add a new student";

	public static final String SELECT_COURSE_TO_ENROLL_STUDENTS = "Select course to enroll student";

	public static final String EXPLANATION_ENROLL_STUDENT_TO_COURSE = "Explanation enroll student to course";

	public static final String ERROR_NO_VALUE_SELECTED_IN_LIBRARY = "Error no value selected in library";

	public static final String SETTINGS_FOR_CODING = "Settings for programming assignments";

	public static final String SHOW_STUDENT_OUTPUT = "Show student output";

	public static final String SHOW_CORRECT_OUTPUT = "Show correct output";

	public static final String SHOW_RUNTIME_ERRORS = "Show runtime errors";

	public static final String REVIEW_TASKS = "Review tasks";

	public static final String OUTLINE = "Outline";

	public static final String SHOW_CONTENT_IN_OUTLINE = "Show content in Outline";

	public static final String EDIT_OBJECT_RESOURCE = "Edit object resource";

	public static final String OBJECT_URL = "Object URL";

	public static final String USE_PARENT_STYLES = "Use inherited parent styles";

	public static final String USE_PARENT_STYLES_DESCRIPTION = "Use parent styles description";

	public static final String CREATE_NEW_TABLE = "Create a New Table";

	public static final String NUMBER_OF_COLUMNS = "Number of columns";

	public static final String COLUMN_N = "Column @0";

	public static final String ROW_N = "Row @0";

	public static final String USE_WYSIWYG_EDITOR = "Use WYSIWYG editor";

	public static final String ERROR_TABLE_MUST_HAVE_ONE_ROW_COLUMN = "Table must have at least one row and one column!";

	public static final String CELL_MASTER_STYLE = "Cell master style";

	public static final String TABLE_EDITOR = "Table editor";

	public static final String TABLE = "Table";

	public static final String ADD_COLUMN = "Add column";

	public static final String DELETE_COLUMN = "Delete column";

	public static final String OWN_RESOURCES = "Own resources";

	public static final String PUBLIC_RESOURCES = "Public resources";

	public static final String UTILIZE = "Utilize";

	public static final String UPDATE_OR_SAVE_NEW_PRESET = "Update or Save New Preset";

	public static final String UPDATE_OR_SAVE_NEW_PRESET_MESSAGE = "Choose whether you want to update the preset @0, or save a new preset:";

	public static final String OVERWRITE = "Overwrite";

	public static final String SAVE_NEW = "Save new";

	public static final String START_TUTORIAL = "Start Tutorial";

	public static final String TUTORIAL = "Tutorial";

	public static final String EDIT_TUTORIAL = "Edit tutorial";

	public static final String DELETE_RESOURCES_DESCRIPTION = "delete resources description";

	public static final String CONFIRM_TUTORIAL_DELETE_MESSAGE = "Confirm tutorial delete msg";

	public static final String DELETED = "Deleted!";

	public static final String GROUPS = "Groups";

	public static final String SELECT_THE_SORTING_EXERCISE_TYPE = "Select the Sorting exercise type";

	public static final String IMAGE_PUZZLE = "Image Puzzle";

	public static final String IMAGE_PUZZLE_EXPLANATION = "Image Puzzle explanation";

	public static final String TEXT_SHUFFLE = "Text Shuffle";

	public static final String TEXT_SHUFFLE_EXPLANATION = "Text Shuffle explanation";

	public static final String ILLEGAL_OPERATION_AT_LINE = "Illegal operation at line";

	public static final String GROUP_NAME = "Group name";

	public static final String NEW_GROUP = "New group";

	public static final String SELECT_GROUP_TO_EDIT = "Select group to edit";

	public static final String EDIT_GROUP = "Edit group";

	public static final String USERS_NOT_ASSIGNED = "Users not assigned";

	public static final String SELECT_GROUP_OR_USER_TO_REMOVE = "Select group or user to remove";

	public static final String SELECT_AT_LEAST_ONE_REVIEWER = "Select at least one reviewer";

	public static final String SELECT_REVIEWERS = "Select reviewers";

	public static final String ASSIGN_STUDENTS = "Assign students";

	public static final String ASSIGN_SELECTED = "Assign selected";

	public static final String STUDENTS_NOT_ASSIGNED = "Students not assigned";

	public static final String STUDENT = "Student";

	public static final String SELECT_ASSIGNMENTS = "Select assignments";

	public static final String SELECT_EVALUATION_SETS = "Select evaluation sets";

	public static final String SUBMISSIONS_TO_REVIEW = "Submissions to review";

	public static final String EVALUATE = "Evaluate";

	public static final String EVALUATE_SUBMISSION_BY = "Evaluate submission by @0";

	public static final String STUDENT_SUBMISSION = "Student submission";

	public static final String SELECT_AT_LEAST_ONE_ASSIGNMENT = "Select at least one assignment";

	public static final String SELECT_EVALUATION_SETS_FOR_ALL_ASSIGNMENTS = "Select evaluation set for all assignments";

	public static final String MOVE_SECTION_UP = "Move section up";

	public static final String MOVE_SECTION_DOWN = "Move section down";

	public static final String RENAME_SECTION = "Rename section";

	public static final String SELECT_MANUAL_GRADED_TYPE = "Select the manual graded type:";

	public static final String MANUAL_EXAM_DESCRIPTION = "manual exam description";

	public static final String DEMONSTRATIONS = "Demonstrations";

	public static final String MANUAL_DEMO_DESCRIPTION = "manual demo description";

	public static final String STUDY_JOURNAL = "Study Journal";

	public static final String MANUAL_JOURNAL_DESCRIPTION = "manual journal description";

	public static final String OTHER = "Other";

	public static final String MANUAL_OTHER_DESCRIPTION = "manual other description";

	public static final String EXAM = "Exam";

	public static final String SELECT_JOURNAL = "Select a journal:";

	public static final String CREATE_NEW_JOURNAL = "Create a new journal";

	public static final String CREATE_NEW_COURSE = "Create a new course";

	public static final String ADD_ENTRY_PAGES = "Add entry pages";

	public static final String ADD_GRADING = "Add grading";

	public static final String SELECT_SURVEY_TO_USE_AS_ENTRY_PAGE = "Select a survey to use as an entry page";

	public static final String EDIT_JOURNAL_DESCRIPTION = "edit journal description";

	public static final String DELETE_JOURNAL_QUESTION = "Delete journal?";

	public static final String DELETE_JOURNAL_DESCRIPTION = "Delete journal description";

	public static final String SELECT_ROUNDS_TO_ADD_ENTRY_PAGE = "Select rounds to add entry page into";

	public static final String ERROR_NO_ROUND_SELECTED = "Error no round selected";

	public static final String ERROR_ALL_ROUNDS_ALREADY_HAVE_ENTRY_PAGES = "Error all rounds already have entry pages";

	public static final String ERROR_NO_MANUAL_GRADED_ASSIGNMENTS_IN_COURSE = "Error no manual assignments in course";

	public static final String ENTRIES_WRITTEN = "Entries written";

	public static final String DEMONSTRATIONS_EDIT_DESCRIPTION = "Demonstrations edit description";

	public static final String FIELD_TITLE = "Field title";

	public static final String ADD_DEMONSTRATION = "Add demonstration";

	public static final String EDIT_DEMONSTRATION = "Edit demonstration";

	public static final String NEW_DEMONSTRATION = "New demonstration";

	public static final String ATTENDANCE = "Attendance";

	public static final String ATTENDANCE_ADVANCED = "ATTENDANCE_ADVANCED";

	public static final String ATTENDANCE_NORMAL = "ATTENDANCE_NORMAL";

	public static final String ATTENDANCE_LOCATION = "ATTENDANCE_LOCATION";

	public static final String ATTENDANCE_FROMDATE = "ATTENDANCE_FROMDATE";

	public static final String ATTENDANCE_TODATE = "ATTENDANCE_TODATE";

	public static final String ATTENDANCE_INTERVALENDED = "ATTENDANCE_INTERVAL_ENDED";

	public static final String ATTENDANCE_INTERVAL_START_AFTER_END = "ATTENDANCE_INTERVAL_START_AFTER_END";

	public static final String ATTENDANCE_INTERVAL_TOO_SHORT = "ATTENDANCE_INTERVAL_TOO_SHORT";

	public static final String ATTENDANCE_CHECK_EVENT_DATA = "ATTENDANCE_CHECK_EVENT_DATA";

	public static final String ATTENDANCE_SPECIFIC_EVENTNAME = "ATTENDANCE_SPECIFIC_EVENTNAME";

	public static final String ATTENDANCE_DEVICEOVERLAP = "ATTENDANCE_DEVICE_OVERLAP";

	public static final String ATTENDANCE_ALL_EVENTS = "All events";

	public static final String ATTENDANCE_EVENTS_ON_COURSE = "Events on course";

	public static final String ATTENDANCE_EVENT_NOT_ON_COURSE = "Event not on this course!";

	public static final String ATTENDANCE_NO_DEVICE_SELECTED = "RFID-device not selected!";

	public static final String ATTENDANCE_EXISTING_EVENT = "ATTENDANCE_EXISTING_EVENT";

	public static final String PRESENTATION = "Presentation";

	public static final String INCLUDE_ATTENDANCE_FIELD = "Include attendance field";

	public static final String INCLUDE_PRESENTATION_FIELD = "Include presentation field";

	public static final String EXERCISE_FIELDS = "Exercise fields";

	public static final String AUTO_FILL = "Auto fill";

	public static final String ASSIGN_AUTOMATICALLY = "Assign automatically";

	public static final String NUMBER_OF_EXERCISES = "Number of exercises";

	public static final String FIELD_NAME_TEMPLATE = "Field name template";

	public static final String INPUT_METHOD = "Input method";

	public static final String ENTER_SCORE = "Enter score";

	public static final String MARK_AS_DONE = "Mark as done";

	public static final String CALCULATE_TOTALS = "Calculate totals";

	public static final String INCLUDE_TO_TOTAL_SCORE = "Include to total score";

	public static final String NOT_INCLUDED_TOT_TOTAL_SCORE_EXPLANATION = "Not included to total score explanation";

	public static final String DEMONSTRATION_DELETE_QUESTION = "Demonstration delete question";

	public static final String TEACHER_HASNT_GRADED_THIS_ASSIGNMENT_YET = "Teacher hasn't graded this assignment yet.";

	public static final String STUDENT_INPUT_MODE = "Student input mode";

	public static final String CLICK_YOUR_NAME_TO_ENTER_SCORES = "Click your name to enter your scores";

	public static final String YOU_NEED_TO_ENTER_TEACHER_PASSWORD_TO_CLOSE_DIALOG = "You need to enter the teacher password to close this dialog.";

	public static final String INCORRECT_PASSWORD = "Incorrect password!";

	public static final String RFID_OR_STUDENT_NUMBER = "RFID or student number";

	public static final String STUDENT_INPUT_DIALOG_EXPLANATION = "Student input dialog explanation";

	public static final String MANUAL_ATTENDANCE_DESCRIPTION = "manual attendance description";

	public static final String ATTENDANCE_EDIT_DESCRIPTION = "Attendance edit description";

	public static final String NEW_EXAM = "New exam";

	public static final String ARE_YOU_SURE_YOU_WANT_TO_DELETE_EXAM = "Are you sure you want to delete this exam?";

	public static final String EDIT_EXAM_DESCRIPTION = "Edit exam description";

	public static final String EXAM_INSTANCES = "Exam instances";

	public static final String ADD_INSTANCE = "Add instance";

	public static final String ARE_YOU_SURE_TO_DELETE_INSTANCE = "Are you sure you want to delete this instance?";

	public static final String EXAM_ATTACHED_EDIT_WARNING = "Exam attached edit warning";

	public static final String PROFILE_PICTURE_NOT_FOUND = "Profile picture was not found";

	public static final String CODING_EXERCISES = "Coding exercises";

	public static final String CODING_EXERCISES_DESC = "Category for coding exercises";

	public static final String GENERAL_EXERCISES = "General exercises";

	public static final String GENERAL_EXERCISES_DESC = "Category for generally usable exercises";

	public static final String MATH_EXERCISES = "Math exercises";

	public static final String MATH_EXERCISES_DESC = "Category for mathematical exercises";

	/* Achievement constants */

	public static final String COUNTER_DESC_SUBMISSION_COUNT = "Make at least @0 submissions";

	public static final String COUNTER_DESC_MAX_SCORE_ASSIG = "Get maximum score from at least @0 assignments";

	public static final String COUNTER_DESC_TWO_OR_MORE_SUBM = "Make at least two submissions for at least @0 assignments";

	public static final String COUNTER_DESC_ATTENDANCE_COUNT = "Attend at least @0 events";

	public static final String COUNTER_DESC_SUBMITTED_TO_ASSIGS = "Make a submission to @0 different assignments";

	public static final String COUNTER_DESC_PERSISTENCE = "Make at least @0 submissions to certain assignment";

	public static final String COUNTER_DESC_NIGHT_RIDING = "Make at least @0 submissions in night time";

	public static final String COUNTER_DESC_DEMOS_ATTENDED = "Attend at least @0 demonstration meetings";

	public static final String COUNTER_DESC_DEMO_EXERS_DONE = "Make at least @0 demonstration exercises";

	public static final String COUNTER_DESC_DEMO_PRESENTATIONS = "Give at least @0 presentations in demo meetings";

	public static final String COUNTER_DESC_DEMO_MAX_CALC = "Do all the exercises for at least @0 demo meetings";

	public static final String COUNTER_DESC_MAX_WITH_FIRST_SUBM = "Get maximum score with first try from at least @0 assignments";

	public static final String COUNTER_DESC_MAX_SUBMS_TO_DIFF_ASSIG_SESSION = "Submit to @0 different assignments in a single session";

	public static final String COUNTER_DESC_MAX_SUBMS_TO_DIFF_COURSE_SESSION = "Submit to assignments on @0 different courses in a single session";

	public static final String COUNTER_DESC_LONGEST_SESSION_MINUTES = "Have a ViLLE-session that is at least @0 minutes long ";

	public static final String COUNTER_DESC_MOST_CONSEC_LOG_IN_DAYS = "Log in to ViLLE in @0 consecutive days";

	public static final String COUNTER_DESC_MAX_SCORE_ROUND = "Get maximum score from @0 rounds";

	public static final String COUNTER_DESC_ROUND_MAX_WITH_THREE_DAYS_LEFT = "Get maximum score from a round with at least three days left before dead-line @0 times";

	public static final String COUNTER_DESC_LECTURES_ATTENDED = "Attend @0 ViLLE-lectures";

	public static final String COUNTER_DESC_TUTORINGS_ATTENDED = "Attend @0 ViLLE-tutoring events";

	public static final String COUNTER_DESC_EXTRA_CURRS_ATTENDED = "Attend @0 extra curricular (ViLLE-related) activities";

	public static final String TO_UNLOCK_THIS_ACHIEVEMENT = "To unlock this achievement you must";

	public static final String ACHIEVED_FROM_COURSE = "Achieved from course: @0";

	public static final String ACHIEVABLE_ON_COURSE = "Achievable on course: @0";

	public static final String SPECIALLY_GIVEN_ACH_EL = "Special achievements";

	public static final String GLOBAL_ELEMENT_TYPE = "Global achievements";

	public static final String SECRET_UNLOCK_STRING = "Exact requirements for this achievement are kept secret!";

	public static final String ACH_BEGINNER = "Beginner";

	public static final String ACH_AMATEUR = "Amateur";

	public static final String ACH_GOOD = "Good";

	public static final String ACH_EXCELLENT = "Excellent";

	public static final String ACH_GREAT = "Great";

	public static final String ACH_BRILLIANT = "Brilliant";

	public static final String ACH_STUNNING = "Stunning";

	public static final String ACH_ENLIGHTENED = "Enlightened";

	public static final String ACH_UNFORGETTABLE = "Unforgettable";

	public static final String ACH_ROYAL = "Royal";

	public static final String ACH_SUPERNATURAL = "Supernatural";

	public static final String ACH_GURU = "Guru";

	public static final String ACH_TITANIC = "Titanic";

	public static final String ACH_DEMIGOD = "Demigod";

	public static final String ACH_GODLIKE = "Godlike";

	public static final String ACH_NEW_LEVEL = "New level";

	public static final String ACHIEVEMENT_UNLOCKED = "Achievement unlocked";

	public static final String NEW_LEVEL_UNLOCKED = "New level unlocked: @0";

	/* end of achievement constants */

	public static final String VISUALIZE = "Visualize";

	public static final String ROBOT_EXERCISE_EXPLANATION = "In the the robot exercise, one can create crane programming exercises of varying difficulties. This exercise type is excelent for visualizing loop structures and repetition in general.";

	// Virhe komennon suorituksessa
	public static final String COMMAND_EXECUTION_FAILURE = "Command execution failure";

	// Komentoa @0 ei voida suorittaa
	public static final String UNABLE_TO_EXECUTE_COMMAND = "Unable to execute command @0";

	// Komento ohitetaan
	public static final String ROBOT_INVALID_COMMAND_DESC = "The command will be ignored and you will receive no points";

	// Voi johtaa ep��validiin tilaan komentoja uudelleen- tai
	// takaperintoistettaessa
	public static final String ROBOT_ANIM_AFTER_FAILURE_DESC = "You can continue viewing what your next commands do to help you debug your code. "
			+ " However the failed command may cause invalid state while replaying commands";

	public static final String SELECT_GROUP = "Select group";

	public static final String LONG_DIVISION = "Long division";
	
	public static final String OPERATION_MULT = "Multiplication";
	
	public static final String MATH_CONNECT = "Combine equal items";
	
	public static final String MY_COURSES = "My courses";

	public static final String RECENT_EVENTS = "Recent events";

	public static final String UPCOMING_DEADLINES = "Upcoming deadlines";

	public static final String LATEST_ACHIEVEMENTS = "Latest achievements";

	public static final String CALCROW_PREFILL = "CALCROW_Prefill_calculation";

	public static final String CALCROW_SHOWUNITS = "CALCROW_SHOWUNITS";

	public static final String RESEARCH_PROJECT = "Research project";

	public static final String PROFILE = "Profile";

	public static final String MY_VILLE = "My ViLLE";

	public static final String THERE_ARE_NO_EVENTS_TO_DISPLAY = "There are no events to display.";

	public static final String THERE_ARE_NO_ACHIEVEMENTS_TO_DISPLAY = "You haven't collected any achievements yet.";

	public static final String THERE_ARE_NO_DEADLINES_TO_DISPLAY = "There are no upcoming deadlines to display.";

	public static final String YOU_ARE_NO_REGISTERED_TO_ANY_COURSES = "You are not currently registered into any courses.";

	public static final String PROFILE_HAKA_USER_MSG = "Profile HAKA user message";

	/**** Help texts for editor ****/

	

	public static final String DAYS_HOURS = "@0 days @1 hours";

	public static final String TOTAL_PRESENTATIONS = "Total presentations";

	public static final String DEMO_PRESENTATION_DIALOG_EXPLANATION = "Demo presentation dialog explanation";

	public static final String ADD_ACHIEVEMENTS = "Add achievements";

	public static final String UPDATE_ACHIEVEMENTS = "Update achievements";

	public static final String ATTENDANCE_SAVED = "Attendance saved";

	public static final String ATTENDANCE_INPUT_DIALOG_EXPLANATION = "Attendance input dialog explanation";

	public static final String SELECT_PRESENTERS = "Select presenters";

	public static final String ALL_ACHIEVEMENTS = "All achievements";

	public static final String USER_NOT_REGISTERED_IN_COURSE = "User not registered to the course";

	public static final String DEMO_MARKINGS_ARE_LOCKED = "Your demo markings are locked";

	public static final String ASSIGN_PRESENTERS = "Assign presenters";

	public static final String EXERCISE_LOAD_ERROR = "Could not load the exercise";

	public static final String TYPE_SUBMISSION_VIEWER_NOT_IMPLEMENTED = "Submission viewer is not implemented for this exercise type";

	public static final String TYPE_SUBMISSION_EXPORT_NOT_IMPLEMENTED = "Submission export is not implemented for this exercise type";

	public static final String TYPE_SUBMISSION_STATISTICS_GIVER_NOT_IMPL = "Submission statistics viewer is not implemented for this exercise type";

	public static final String NOT_ENOUGH_INFORMATION_STORED_TO_VIEW_SUBMISSION = "Unfortunately there is not enough information stored about this submission to view it.";

	public static final String SHOW_USER_ANSWER = "Show answer given by user";

	public static final String SHOW_CORRECT_ANSWER = "Show correct answer";

	public static final String GENERAL_SORTING_SUBM_VIEWER_DESCRIPTION = "Components are shown either in the way they were sorted by the student or "
			+ " in the way they should be sorted in the correct answer. Regardless of the mode components that student "
			+ "	sorted correctly are shown with green border, incorrectly sorted with red border, and fixed components with grey border.";

	public static final String ASSIGN_STUDY_GROUPS = "Assign study groups";

	public static final String BC_LOW_LIMIT = "Minimum (in decimal) for numbers used in conversions";

	public static final String GROUP = "Group";

	public static final String EXCELLENT = "Excellent!";

	public static final String AWESOME = "Awesome!";

	public static final String MAGNIFICENT = "Magnificent!";

	public static final String SUPERB = "Superb!";

	public static final String GREAT_WORK = "Great work!";

	public static final String GOOD = "Good!";

	public static final String WELL_DONE = "Well done!";

	public static final String GOOD_JOB = "Good job!";

	public static final String NICE_TRY = "Nice try!";

	public static final String KEEP_WORKING = "Keep working!";

	public static final String TRY_AGAIN = "Try again!";

	public static final String SHOW_GROUPS = "Show groups";

	public static final String GRADE_SCALE_EXPLANATION = "Grade scale explanation";

	public static final String GRADING_TEMPLATES = "Grading templates";

	public static final String CHANGE_TO_ANOTHER_INSTANCE = "Change to another instance?";

	public static final String CHANGE_INSTANCE_MESSAGE = "Change instance message";

	public static final String AUTO_GRADE = "Auto grade";

	public static final String POINT_LIMIT = "Point limit";

	public static final String POINT_LIMITS_FOR_GRADES = "Point limits for grades";

	public static final String POINT_LIMIT_ERROR = "Point limit error";

	public static final String SHOW_PRESENTERS = "Show presenters";

	public static final String ALLOW_COLLABORATION = "Allow collaboration";

	public static final String LECTURE_MODE = "Lecture mode";

	public static final String ARCHIVED = "ARCHIVED";

	public static final String INACTIVE = "INACTIVE";

	public static final String AS_ASSISTANT_TEACHER = "AS_ASSISTANT_TEACHER";

	public static final String ARCHIVE = "ARCHIVE";

	public static final String AD_HOC_EXERCISE = "Ad hoc exercise";

	public static final String COLLABORATORS = "Collaborators";

	public static final String CLEAR = "Clear";

	// /* FILL-IN-EXERCISE */
	public static final String FILL_IN_EXERCISE = "Fill in exercise";

	public static final String FILL_IN_EXERCISE_EXPLANATION = "Fill in exercise explanation";

	public static final String ERROR_STUDENT_ID_NUMBER_MATCH = "User id and student number don't match";

	public static final String EXAM_WILL_CLOSE_IN = "The exam will close in";

	public static final String ADD_CURRENT_DEADLINE = "Close the round for a student";

	public static final String ALL_QUIZ_QUESTIONS_SELECTABLE = "Quiz questions can be answered in any order";

	public static final String COUNT_WORDS = "Count words";

	public static final String WORD_COUNT = "Word count: @0";

	public static final String RFID = "RFID";

	public static final String INVALID_RFID = "Illegal RFID (should consist of 8 alpha-numeric characters)";

	public static final String RFID_ALREADY_IN_USE = "The given RFID is already in use";

	public static final String ERROR_EDITING_RFID = "The used rf-id value is invalid. You can also leave it empty if rfid is not needed.";

	public static final String EXERCISE_COPIED = "Exercise copied";

	public static final String SURVEY_FEEDBACK = "Survey feedback";

	public static final String UNSUBMITTED_CHANGES_CONFIRM_EXIT = "Do you want to leave without submitting your answers?";

	public static final String UNSUBMITTED_CHANGES_OK_BUTTON_CAPT = "Discard changes and leave";

	public static final String ERROR_NO_EXERCISES_IN_POOL = "There are no exercises in the pool";

	public static final String UNSUBMITTED_CHANGES_CONFIRM_EXIT_CAPT = "Unsubmitted changes";

	public static final String FIRST_DEGREE_NAME = "First degree equations";

	public static final String DISABLE_SPELL_CHECK = "Disable spell-check";

	public static final String SHOW_COUNT_WORDS_BUTTON = "Show count words button";

	public static final String ORDER_BY = "Order by";

	public static final String ALL = "All";

	public static final String MANAGE_EVENTS = "Manage events on your rf-id devices";

	public static final String REMOVE_FROM_OWNERS = "Remove from owners";

	public static final String ERROR_PERCENTAGES_SUM_NOT_100 = "The sum of percentages must be 100";

	public static final String ANSWER_CHOICES = "Answer choices";

	public static final String ASSIGNMENT_HAS_SUBMISSIONS_TOOLTIP = "Assignment has submissions explanation";

	public static final String EXERCISE_HAS_SUBMISSIONS_EXPLANATION = "Exercise has submissions explanation";

	public static final String DELETE_SUBMISSIONS = "Delete submissions";

	public static final String DELETE_SUBMISSION_CONFIRM_MESSAGE = "Delete submission confirmation msg";

	public static final String MULTIPLE_CHOICE = "Multiple choice";

	public static final String MATH_MULTIPLE_CHOICE = "Math multiple choice";

	public static final String MULTIPLE_CHOICE_PERCENTAGES_SELECT_ONE = "Multible choice percentages select one";

	public static final String MULTIPLE_CHOICE_SELECT_MANY = "Multible choice percentages select many";

	public static final String PREVIOUS_ANSWER_IN_YELLOW = "Previous answer is marked in yellow";

	public static final String USE_TEMPLATE = "Use template";

	public static final String MATH_AUDIO_ARITHMETIC = "Math audio arithmetic";

	public static final String TESTING = "Testing";

	public static final String MULTIPLE_CHOICE_PERCENTAGE = "Multiple choice percentage";

	public static final String SELECT_FILE = "Select file";

	public static final String UPLOAD_FILE = "Upload file";

	public static final String PLEASE_SELECT_TO_UPLOAD = "Please select a file to upload";

	public static final String ADD_SELECTED_STUDENT_EXPLANATION = "Add selected student explanation";

	public static final String ADD_STUDENT_FROM_YOUR_ORGANIZATION = "Add student from your organization";

	public static final String ADD_STUDENT_FROM_ORGANIZATION_EXPLANATION = "Add student from organization explanation";

	public static final String ADD_OTHER_STUDENT = "Add other student";

	public static final String ADD_OTHER_STUDENT_EXPLANATION = "Add other student explanation";

	public static final String USER_NOT_FOUND = "User not found";

	public static final String USER_NOT_FOUND_MSG = "User not found msg";

	public static final String ENROLL_TITLE = "Enroll title";

	public static final String STUDENT_ENROLLED = "Student enrolled!";

	public static final String YOU_HAVE_REQUEST_TO_ENROLL_COURSE = "You have been sent a request to enroll into the following course:";

	public static final String READ_RFID_TAG = "Read RFID tag";

	public static final String READING_RFID_ENROLLS_USER_INTO_COURSE = "Reading user's RFID tag enrolls user into @0.";

	public static final String STUDENT_ENROLLED_NAME = "Student enrolled: @0.";

	public static final String REQUEST_SENT = "Request sent!";

	public static final String ACCEPT = "Accept";

	public static final String DECLINE = "Decline";

	public static final String ANSWER_GRID = "Answer grid";

	public static final String ANSWER_GRID_EXPLANATION = "Answer grid explanation";

	public static final String ARRANGE_SENTENCES_NAME = "Arrange sentences";
	public static final String ARRANGE_SENTENCES_DESC = "Arrange sentences desc";

	public static final String MATCH_PAIRS_NAME = "Match pairs";
	public static final String MATCH_PAIRS_DESC = "Match pairs desc";
	public static final String VOCABULARY_TEST_NAME = "Vocabulary test";
	public static final String VOCABULARY_TEST_DESC = "Vocabulary test desc";

	public static final String SELECT_ANOTHER_FILE = "Select another file";

	public static final String UPLOADING_INTERRUPTED = "Upload interrupted";

	public static final String UPLOADING_FILE_NAMED = "Uploading file '@0'";

	public static final String UPLOADING_FILE_NAMED_SUCCEEDED = "Uploading file '@0' succeeded";

	public static final String HEIGHT = "Height";

	public static final String DIALOG_EXER_NAME = "Dialog exercise";

	public static final String DIALOG_EXER_DESC = "Dialog exercise desc";

	public static final String ATTACH_IMAGE_AND_TEXT = "Attach image and text";

	public static final String ERROR_ATLEAST_ONE_QUESTION_REQUIRED = "Error at least one question req";

	public static final String SORT = "Sort";

	public static final String STATISTICS_TYPE_COLUMNS = "Statistics type columns";

	public static final String SURVEY_PICTURE = "Picture component";

	public static final String SURVEY_PICTURE_EXPLANATION = "Add a picture to the survey";

	public static final String UPLOAD_A_PICTURE = "Upload new picture";

	public static final String SURVEY_PICTURE_UPLOAD_ERROR = "Survey picture upload error";

	public static final String SURVEY_ERROR_SAVING_PICTURE_COMP = "Error in saving the picture component";

	public static final String SELECT_ENROLL_TYPE = "Select enrollment type";

	public static final String ENROLL_TYPE_EMAIL_DESCRIPTION = "Enroll type email desc";

	public static final String ENROLL_TYPE_OTHER_DESCRIPTION = "Enroll type other desc";

	public static final String OTHER_ID = "Other id";

	public static final String USER_ID = "User id";

	public static final String ORGANIZATION_ID = "Organization id";

	public static final String ADD_USER_INFO = "Add user info";

	public static final String PREVIEW_AND_SAVE = "Preview and save";

	public static final String PASSWORD_DIFFICULTY = "Password difficulty";

	public static final String USERIDS_ALREADY_IN_VILLE_WILL_BE_ADDED_TO_COURSE = "User ids already in ViLLE will be added to course";

	public static final String STUDENTLIST_TXT = "studentlist.txt";

	public static final String OVERRIDE_GRADE = "Override grade";

	public static final String OVERRIDE = "Override";

	public static final String OVERRIDE_PEER_SCORE = "Override peer-review score";

	public static final String REVIEW_BY = "Review by @0";

	public static final String SELECT_ASSESSMENT_TYPE = "Select assessment type";

	public static final String GRADE_AUTOMATICALLY = "Grade automatically";

	public static final String GRADE_AUTOMATICALLY_EXPLANATION = "Grade automatically explanation";

	public static final String GRADE_MANUALLY = "Grade manually";

	public static final String GRADE_MANUALLY_EXPLANATION = "Grade manually explanation";

	public static final String ENTER_EMAIL_STUDENTID_RFID = "Enter rfid or username or student number";

	public static final String ERROR_NO_SUCH_STUDENT_IN_COURSE = "Error no such user in course";

	public static final String BACK_TO_TOP = "Back to top";

	public static final String NOT_SUPPORTED_IN_IE = "Not supported in Internet Explorer";

	public static final String SELECT_INTERVAL = "Select interval";

	public static final String ERROR_SELECT_BOOKMARK_TO_DELETE_IT = "Select bookmark to delete";

	public static final String NEWS = "News";

	public static final String THERE_ARE_NO_NEWS_TO_DISPLAY = "There are no news to display.";

	public static final String CREATE_NEWS_ITEM = "Create news item";

	public static final String CREATE_NEW_EVENT = "Create new event";

	public static final String EDIT_NEWS_ITEM = "Edit news item";

	public static final String NEWS_HEADING = "News heading";

	public static final String NEWS_CONTENT = "News content";

	public static final String YOU_HAVE_NO_COURSES_SELECT_COURSE_TAB = "YOU_HAVE_NO_COURSES_SELECT_COURSE_TAB";

	public static final String YOU_HAVE_NO_COURSES_CLICK_BUTTON_BELOW_TO_CREATE_ONE = "You have no courses. Click the button below to create one.";

	public static final String DELETE_NEWS_ITEM = "Delete news item";

	public static final String CONDITIONAL_ROUND = "Conditional round";

	public static final String FROM_PREVIOUS_REQUIRED = "from previous required";

	public static final String BOOKING_CALENDAR = "Booking Calendar";

	public static final String BOOKING_CALENDAR_DESCRIPTION = "Create new calendar for reserving rooms";

	public static final String FILE_UPLOAD_MAX_SIZE_KB = "File upload max size @0 kB.";

	public static final String COURSE_ASSIGNMENTS = "Course assignments";

	public static final String NEW_COURSE_ASSIGNMENT = "New course assignment";

	public static final String STAGES = "Stages";

	public static final String ADD_STAGE = "Add stage";

	public static final String STAGE_ASSIGNMENT = "Stage assignment";

	public static final String COURSE_ASSIGNMENT = "Course assignment";

	public static final String COURSE_ASSIGNMENT_DESCRIPTION = "Course assignment description";

	public static final String ADD_REGISTRATION_ASSIGNMENT = "Add registration assignment";

	public static final String THERE_ARE_NO_STAGES_DEFINED = "There are no stages defined yet!";

	public static final String EDIT_STAGE = "Edit stage";

	public static final String STAGE_NAME = "Stage name";

	public static final String SELECT_ASSIGNMENT_TO_USE_IN_STAGE = "Select assignment to use in this stage";

	public static final String ERROR_NO_STAGES_DEFINED = "Error no stages defined";

	public static final String ARE_YOU_SURE_TO_DELETE_COURSE_ASSIGNMENT = "Are you sure you want to delete this course assignment?";

	public static final String MANUAL_MATH_NAME = "Manual math exercise";

	public static final String MANUAL_MATH_EXPL = "Manual math explanation";

	public static final String COURSE_ASSIG_ALREADY_ATTACHED_MSG = "Course assignment already attached msg";

	public static final String COMPOUND_EXER_NAME = "Compound exercise";

	public static final String COMPOUND_EXER_EXPL = "Compound explanation";

	public static final String PUNCT_AND_CASE_NAME = "Punctuation and case exercise";

	public static final String PUNCT_AND_CASE_EXPL = "Punctuation and case explanation";

	public static final String SELECT_WORDS_NAME = "Select words exercise";

	public static final String SELECT_WORDS_EXPL = "Select words explanation";

	public static final String REGISTER_TO_ROUND = "Register to round";

	public static final String CURRENT_STAGE = "Current stage:";

	public static final String VIEW_ASSIGNMENT_FOR_CURRENT_STAGE = "View assignment for current stage";

	public static final String THIS_STAGE_IS_NOT_RATED_YET = "This stage is not rated yet.";

	public static final String THIS_STAGE_WAS_COMMENTED_BY_SUPERVISOR = "This stage was commented by your supervisor.";

	public static final String YOU_NEED_TO_RESUBMIT_THIS_STAGE = "You need to re-submit the assignment for this stage.";

	public static final String THIS_STAGE_IS_COMPLETED = "This stage is completed.";

	public static final String VIEW_HISTORY = "View history";

	public static final String PREVIOUS_STAGES = "Previous stages";

	public static final String STAGE_NUM = "Stage @0";

	public static final String OVERALL_VIEW = "Overall view";

	public static final String STAGE_NUM_NAME = "Stage @0: @1";

	public static final String FINAL_GRADING = "Final grading";

	public static final String ACCEPTED = "Accepted";

	public static final String USER_ALREADY_REGISTERED_TO_ANOTHER_GROUP = "User already registered to another group";

	public static final String COMPLETED = "Completed";

	public static final String GRADED = "Graded";

	public static final String GRADE_ASSIGNMENT = "Grade assignment";

	public static final String CLOSE = "Close";

	public static final String ACCEPT_OR_DECLINE_REGISTRATION = "Accept or decline registration";

	public static final String SEND_A_COPY_OG_MSG_TO_FOLLOWING_ADDRESSES = "Send copy of message to following addresses";

	public static final String STAGE = "Stage";

	public static final String SUBMITTED = "Submitted";

	public static final String VIEW_ASSIGNMENT = "View assignment";

	public static final String COURSE_ASSIG_GRADED_MAIL_TITLE = "Course assignment graded mail title";

	public static final String YOUR_SUBMISSION_WAS_GRADED_WITH_GRADE_BY_TEACHER = "Your submission was graded at @0 by @1 (@2).";

	public static final String SUBMISSION_WAS_ACCEPTED = "Submission was accepted.";

	public static final String SUBMISSION_WAS_REJECTED_YOU_NEED_TO_RESUBMIT = "Submission was rejected. You need to resubmit the stage @0.";

	public static final String VILLE_EMAIL_SIGNATURE = "ViLLE mail signature";

	public static final String SEND_YOURSELF_COPY_OF_MSG = "Send yourself a copy of message";

	public static final String COURSE_ASSIG_STAGE_EVALUATED = "Course assignment stage evaluated";

	public static final String YOU_EVALUATED_COURSE_ASSIG_STAGE_BY = "You evaluated a course assignment stage by @0.";

	public static final String FOLLOWING_MSG_WAS_SENT_TO_STUDENTS = "The following message was sent to students:";

	public static final String MATRIX_SELECTION_NAME = "Matrix selection exercise";
	public static final String MATRIX_SELECTION_EXPL = "Matrix selection explanation";

	public static final String EDITING_RIGHTS = "Editing rights";

	public static final String SELECT_A_TEACHER_FIRST = "Select a teacher from the list first!";

	public static final String SELECT_WORKSPOT = "Select workspot";

	public static final String NEW_EVENT = "New event";

	public static final String WORKSPOT = "Workspot";

	public static final String WORKSPOT_DESCR = "Create new workspot in selected workspace. Define rounds to limit workspots visibility.";

	public static final String WORKSPACE = "Workspace";

	public static final String WORKSPACE_DESCR = "Create new workspace. A workspace represents classrooms or other similar rooms.";

	public static final String ADD_EDIT_EVENTS = "Add or edit events";

	public static final String EVENTS_DESCR = "Events are empty slots for students to make reservations.";

	public static final String SELECTED = "Selected";

	public static final String SELECT_WORKSPACE = "Select workspace";

	public static final String MAX_AMOUNT_OF_OVERLAPING_EVENTS = "Max. amount of overlapping events in current workspace";

	public static final String BEGINS = "Begins";

	public static final String ENDS = "Ends";

	public static final String REPEAT_WEEKLY = "Repeat weekly n times";

	public static final String RESERVED_FOR = "Reserved for";

	public static final String CANCEL_RESERVATION = "Cancel reservation";

	public static final String RESERVATION_CANCELLED = "Reservation cancelled";

	public static final String UPDATE_ALL_SIMILAR_EVENTS = "Update all similar events";

	public static final String POSSIBLE_EXERS = "Possible exercises";

	public static final String AVAILABLE_EXERCISES = "Available exercises";

	public static final String SELECTED_EXERCISES = "Selected exercises";

	public static final String BOOKING_CALENDAR_DESCR = "Select workspace or edit events, workspaces and workspots";

	public static final String BOOKING_CALENDAR_EDIT_AND_ADD = "Edit workspaces, workspots and events";

	public static final String MAKE_RESERVATION = "Make a reservation";

	public static final String RESERVATION_DESCR = "Make a new reservation. Reservations have to be cancelled at least 24 hours before the event begins.";

	public static final String UNABLE_TO_CANCEL_RESERVATIONS_FROM_PAST = "Unable to cancel reservations from the past";

	public static final String RESERVATION_MADE = "Reservation made";

	public static final String RESERVATION_FAILED = "Could not make reservation. Event is already reserved or there are no more available workspots in workspace";

	public static final String VISITED = "Visited";

	public static final String SHOW_ALL_WORKSPACES = "Show all workspaces";

	public static final String NOT_VISITED = "Not visited";

	public static final String EVENTS_TODAY = "Events today";

	public static final String FUTURE_EVENTS = "Future events";

	public static final String IMAGE_TAG_NAME = "Image tag";

	public static final String IMAGE_TAG_EXPL = "Image tag expl";

	public static final String PREVIOUS_QUESTION = "Previous question";

	public static final String CONFIRM_RESERVATION = "Confirm reservation";

	public static final String CANCEL_CONFIRMATION = "Cancel confirmation";

	public static final String CANCELLED = "Cancelled";

	public static final String RFID_READER = "RFID-reader";

	public static final String SHOW_COMMENTS = "Show comments";

	public static final String SELECT_ONE_OR_MANY_CHOICES = "Select one or many choices";

	public static final String SHOW_MATH_TOOLBAR = "Show math-toolbar";

	public static final String HIDE_MATH_TOOLBAR = "Hide math-toolbar";

	public static final String LECTURES = "Lectures";

	public static final String LECTURE = "Lecture";

	public static final String ATTACH_NO_RF_EVENT = "Attach no RFID-event (manually grade attendance)";

	public static final String YOU_ALREADY_HAVE_A_RESERVATION = "You already have a reservation. You must first cancel previous event to reserve a new event.";

	public static final String RESERVATION = "Reservation";

	public static final String SHOW_CALENDAR = "Show calendar";

	public static final String RFID_ERROR_COUNT = "RFID read errors";

	public static final String ATTENDANCE_ADD_SERIES = "Add series";

	public static final String ATTENDANCE_CALENDAR_NO_EFFECT = "ATTENDANCE_CALENDAR_NO_EFFECT";

	public static final String EVENTS_ON_COURSE = "Events on course";

	public static final String EVENTS = "Events";

	public static final String YOUR_EVENTS = "Your events";

	public static final String ADD_ATT_CLICK_TO_SEL_EXISTING = "Click to select an existing event";

	public static final String IMAGETAG_EXPLANATION = "Add a image with tags to the survey";

	public static final String IMAGETAG = "Image with tags";

	public static final String USE_IMAGE = "Use this image";

	public static final String SURVEY_VIDEO_EXPLANATION = "Add a video to the survey";

	public static final String SURVEY_VIDEO = "Video component";

	public static final String UPLOAD_VIDEO_FROM_FILE = "Upload video from file";

	public static final String LINK_VIDEO = "Link video";

	public static final String LINK_VIDEO_FROM_YOUTUBE = "Link video from youtube";

	public static final String PRACTICAL_WORK = "Practical work";

	public static final String CONFIRM_ASSIGNMENT_DELETE = "Confirm assignment delete";

	public static final String THERE_ARE_SUBMISSIONS_TO_THE_ASSIGNMENT = "There are submissions to the assignment";

	public static final String DISCARD_CHANGES = "Discard changes";

	public static final String DISCARD_CHANGES_MSG = "Discard changes msg";

	public static final String SELECT_ASSIGNMENT_PEER = "Select assignment for peer-review";

	public static final String SELECT_USER_TO_REVIEW = "Select user to review";

	public static final String SHOW_PEER_REVIEWS_STUDENTS = "Show peer-reviews to students";

	public static final String EXAM_PASSWORD = "Exam password";

	public static final String EVENT_NAME = "Event name";

	public static final String STATS_COL_DESC_USER_NAME = "Name of the student";

	public static final String STATS_COL_DECSCS_STUDENT_NUM = "Student number or other id for the student";

	public static final String GS_STAT_HEADER_COL_ROW = "GS_STAT_HEADER_COL_ROW";

	public static final String GS_STAT_COL_DESC_COL_ROW = "GS_STAT_COL_DESC_COL_ROW";

	public static final String VIEW_SUBM_STATS = "Submission Statistics";

	public static final String DESCRIPTION_VIEW_SUBM_STATS = "View statistics on all submissions made to certain assignment";

	public static final String BUG_REP_ENHANCEMENT = "Enhancement";

	public static final String BUG_REP_TRANSLATION = "Translation";

	public static final String BUG_REP_BUG = "Bug";

	public static final String BUG_REP_CRASH = "Crash";

	public static final String CANT_RESERVER_EVENT_IN_THE_PAST = "You can't reserve event in the past";

	public static final String UPDATE_INTERVAL_MSG = "Update interval msg";

	public static final String NOT_STARTED = "Not started";

	public static final String STARTED = "Started";

	public static final String FINISHED = "Finished";

	public static final String STATUS = "Status";

	public static final String EXAM_MONITOR = "Exam monitor";

	public static final String FINISH_EXAM = "Finish exam";

	public static final String FINISH_EXAM_EXPLANATION = "Finish exam explanation";

	public static final String FEEDBACK_TO_CORRECT_ANSWER = "Feedback to correct answer";

	public static final String FEEDBACK_TO_INCORRECT_ANSWER = "Feedback to incorrect answer";

	public static final String TIME_LIMIT = "Time limit";

	public static final String TIMED_ROUND = "Timed round";

	public static final String ASSIGNMENT_WILL_CLOSE_IN = "The assignment will close in";

	public static final String MATH_PERFORMANCE = "Math Performance";

	public static final String MATH_PERFORMANCE_DESCR = "Show student's math performance, if feature is supported by exercises";

	public static final String SELECT_STUDENT = "Select student";

	public static final String EVENTS_TOMORROW = "Events tomorrow";

	public static final String PRACTICAL_WORK_NAME = "Practical work name";

	public static final String EVENT_IS_FULLY_RESERVED = "Event is fully reserved";

	public static final String RESERVATIONS_CANT_BE_CANCELLED_UNDER_24_HOURS_BEFORE_THE_EVENT = "Reservation can't be cancelled under 24 hours before the event";

	public static final String SELECT_ROUNDS = "Select rounds";

	public static final String FIELD_VALUE_MISSING = "Field value missing";

	public static final String TUTORIAL_HAS_CHANGED_MESSAGE = "Tutorial has changed message";

	public static final String CONFIRM_EXIT = "Confirm exit";

	public static final String MATERIAL_ALREADY_ADDED = "Material already added to course!";

	public static final String SUBMISSIONS_TITLE = "Submissions title";

	public static final String REQUIRED = "Required";

	public static final String ROUND_CLOSED = "Round closed";

	public static final String REGISTRATION = "Registration";

	public static final String OWN_TUTORIALS = "Own tutorials";

	public static final String PROFILE_INFORMATION = "Profile information";

	public static final String HOURS_AND_DAYS_AGO = "@0 days and @1 hours ago";

	public static final String EXAM_IS_CLOSED_WOULD_YOU_LIKE = "Exam is closed! Would you like to submit your current answers?";

	public static final String COURSE_EDITOR = "Course editor";

	public static final String COURSE_INFORMATION = "Course information";
	public static final String COPY_ASSIGNMENT = "Copy assignment";

	public static final String COPIED = "Copied";

	public static final String NO_COURSE_TO_COPY_TO = "No course to copy to";

	public static final String CREATE_NEW_ROUND = "Create new round";

	public static final String DRAG_AND_DROP_FILE_HERE = "Drag and drop file here";

	public static final String SET_SIZE = "Set size";

	public static final String LINES_TO_SORT = "Lines to sort";

	public static final String ADD_NEW_SURVEY_COMPONENT = "Add new component to survey";

	public static final String SURVEY_COMPONENTS = "Components of the survey";

	public static final String QUESTIONS = "Questions";

	public static final String BROWSE_TUTORIALS = "Browse tutorials";

	public static final String USED_RFID_DEVICE = "Used rfid-device";

	public static final String REPEAT_TIMES = "Repeat times";

	public static final String REPEAT_INTERVAL = "Repeat interval";

	public static final String GENERATE_ATTENDANCE_ROUND = "Generate attendance round";

	public static final String BASIC_INFORMATION = "Basic information";

	public static final String EVENT_INFORMATION = "Event information";

	public static final String ADD_EXERCISES_TO_POOL = "Add exercises to pool";

	public static final String EXERCISES_IN_POOL = "Exercises in pool";

	public static final String PEER_REVIEW = "Peer review";

	public static final String PEER_SUBMISSIONLESS_REVIEW = "PEER_SUBMISSIONLESS_REVIEW";

	public static final String SELECT_EVALUATION_SET = "Select evaluation set";

	public static final String NEW_EVALUATION_SET = "New evaluation set";

	public static final String EDIT_EVALUATION_SET = "Edit evaluation set";

	public static final String MATH_ROUNDING_NAME = "MATH_ROUNDING_NAME";

	public static final String MATH_ROUNDING_DESC = "MATH_ROUNDING_DESC";

	public static final String GROUP_TAGS = "GROUP_TAGS";

	public static final String SHOW_SUBMITTED_ONLY = "SHOW_SUBMITTED_ONLY";

	public static final String MP_BASE10 = "BASE10";
	public static final String MP_BASE10_OVER = "BASE10_OVER";
	public static final String MP_BASE10_UNDER = "BASE10_UNDER";
	public static final String MP_ADDITION = "ADDITION";
	public static final String MP_SUBTRACTION = "SUBTRACTION";
	public static final String MP_NUMBERLINE = "NUMBERLINE";
	public static final String MP_NUMEROSITY = "NUMEROSITY";
	public static final String MP_EQUALITY = "EQUALITY";
	public static final String MP_MIXOPERATOR = "MIXOPERATOR";
	public static final String MP_LONG_CALCULATION = "LONG_CALCULATION";
	public static final String MP_MULTIPLICATION = "MULTIPLICATION";
	public static final String MP_DIVISION = "DIVISION";
	public static final String MP_CORRECT = "MP_CORRECT";
	public static final String MP_INCORRECT = "MP_INCORRECT";
	public static final String MP_TABLE_SUBHEADER = "MP_TABLE_SUBHEADER";
	public static final String MP_CALCULATION_IN_A_ROW = "CALCULATION_IN_A_ROW";

	public static final String PCS = "PCS";

	public static final String MISCONCEPTIONS = "MISCONCEPTIONS";

	public static final String PROBLEM = "PROBLEM";

	public static final String MP_TABLE_HEADER = "Student's answers and misconceptions";

	public static final String MP_PIE_CHART_HEADER = "Correct/Incorrect answers";

	public static final String MP_STUDENT_PERFORMANCE_HEADER = "Student's learning status";

	public static final String NOT_ENOUGH_TO_DETERMINE = "not enough calculations to determine";

	public static final String MP_SKILL_LEARNED = "Skill is learned";

	public static final String MP_STUDENTS_PERFORMANCE_PER_TAG = "Student's math performance";

	public static final String MP_AMOUNT_OF_ANSWERS = "Amount of answers";

	public static final String MP_ERROR_MSG = "No math performance data found. Try changing the selected course, student or round.";

	public static final String MP_INFO_MSG = "Select course, student and rounds from the left";

	public static final String MP_COURSE_REPORT = "Course report";

	public static final String MP_COURSE_TABLE_HEADER = "All students in course";

	public static final String AVERAGE_CORRECT = "Average of correct answers";

	public static final String AVERAGE_INCORRECT = "Average of incorrect answers";

	public static final String CHECK_TEACHERS_MARKINGS = "Check teacher's markings";

	public static final String TEACHERS_MARKINGS_WINDOW_CAPTION = "Teacher's markings";

	public static final String REQUEST_LOCAL_PASSWORD = "Request local password";

	public static final String LOCAL_PASSWORD_HAS_BEEN_SENT = "Local password has been sent to your email address";

	public static final String YOU_DONT_HAVE_ANY_ACTIVE_COURSES = "You don't have any active courses";

	public static final String BOOKMARK = "Bookmark";

	public static final String BOKMARKED_RESOURCE = "Bookmarked resource";

	public static final String SOURCE_CODE_AND_TRANSLATIONS_SHOULD_HAVE_EQUAL_NUMBER_OF_LINES = "Source code and translations should have equal number of code lines";

	public static final String INCORRECT_DATEFORMAT = "The date is in incorrect format";

	public static final String RE_NUM_OF_BOXES = "RE_Number of Boxes";

	public static final String RE_NUM_OF_EMPTY_BOXES = "RE_Number of empty boxes";

	public static final String RE_MAX_DROP = "RE_Max drop";

	public static final String RE_REFRESH = "RE_Refresh";

	public static final String RE_REFRESH_STATE = "RE_State requires refreshing!";

	public static final String RE_GETCOST = "RE_Number of Cost Limits";

	public static final String RE_STARTPOINTS = "RE_Start Points";

	public static final String RE_ENDPOINTS = "RE_End Points";

	public static final String RE_EMPTYSTART = "RE_Empty box start Points";

	public static final String RE_A1EXTEND = "RE_A1Extend";

	public static final String RE_A2EXTEND = "RE_A2Extend";

	public static final String RE_A3EXTEND = "RE_A3Extend";

	public static final String RE_A1WITHDRAW = "RE_A1Withdraw";

	public static final String RE_A2WITHDRAW = "RE_A2Withdraw";

	public static final String RE_A3WITHDRAW = "RE_A3Withdraw";

	public static final String RE_A3GRAB = "RE_A3Grab";

	public static final String RE_A3DROP = "RE_A3Drop";

	public static final String SHOW_MATERIAL = "Show material";

	public static final String ATTACH_TO_NEW_EVENT = "Attach to a new event";

	public static final String MANUALLY_GRADED_ATTENDANCE = "Manually graded attendance";

	public static final String MAP_ASSIGNMENT_TO_EVENTS = "Map assignment to events";

	public static final String ATTACHED_EVENT_X_TO_THE_ASSIGNMENT = "Attached event @0 to the assignment.";

	public static final String FORUM_SEND = "FORUM.send";

	public static final String FORUM_FOLLOW = "FORUM.follow";

	public static final String FORUM_UNFOLLOW = "FORUM.unFollow";

	public static final String FORUM_REQUEST_HISTORY = "FORUM.requestHistory";

	public static final String FORUM_JUST_NOW = "FORUM.justNow";

	public static final String FORUM_A_MINUTE_AGO = "FORUM.aMinuteAgo";

	public static final String FORUM_N_MINUTES_AGO = "FORUM.nMinutesAgo";

	public static final String FORUM_AN_HOUR_AGO = "FORUM.anHourAgo";

	public static final String FORUM_N_HOURS_AGO = "FORUM.nHoursAgo";

	public static final String FORUM_YESTERDAY = "FORUM.yesterday";

	public static final String FORUM_N_DAYS_AGO = "FORUM.nDaysAgo";

	public static final String FORUM_A_WEEK_AGO = "FORUM.aWeekAgo";

	public static final String FORUM_N_WEEKS_AGO = "FORUM.nWeeksAgo";

	public static final String FORUM_A_MONTH_AGO = "FORUM.aMonthAgo";

	public static final String FORUM_N_MONTHS_AGO = "FORUM.nMonthsAgo";

	public static final String FORUM_A_YEAR_AGO = "FORUM.aYearAgo";

	public static final String FORUM_N_YEARS_GO = "FORUM.nYearsAgo";

	public static final String FORUM_A_LONG_TIME_AGO = "FORUM.aLongTimeAgo";

	public static final String VIEW_AS_STUDENT = "View as student";

	public static final String VIEW_AS_TEACHER = "View as teacher";

	public static final String SELECT_AT_LEAST_ONE_CORRECT_CHOICE = "Select at least one correct choice";

	public static final String INDICATES_CORRECT_CHOICES = "Indicates correct choices";

	public static final String DEMO_PRESENTER_VIEW = "Demo presenter view";

	public static final String DOWNLOAD_FROM_TEACHER_VIEW = "Download from teacher view";

	public static final String ENABLE_DEMO_PRESENTER_VIEW = "Enable demo presenter view";

	public static final String LAST_SUBMISSION_DATE = "Last submission date";

	public static final String VIDEO = "Video";

	public static final String MATERIAL_MANAGER = "Material manager";

	public static final String DROP_FILES_HERE = "Drop files here";

	public static final String GENERATOR_EXPRESSION = "GENERATOR_EXPRESSION";

	public static final String INVALID_EXPRESSION = "Invalid expression";

	public static final String NUMBER_OF_GROUPS = "Number of groups";

	public static final String INEQUALITY_THE_VALUE_SHOULD_NOT_BE_EMPTY = "The value should not be empty.";

	public static final String INEQUALITY_THE_VALUE_SHOULD_NOT_CONTAIN_VARIABLES = "The value should should not contain variables.";

	public static final String INEQUALITY_THE_GIVEN_VALUE_IS_NOT_A_REAL_NUMBER = "The given value is not a real number.";

	public static final String RESTRICTED_EDIT_MODE_MESSAGE = "Restricted edit mode message";

	public static final String DOWNLOAD_REVIEWS = "Download reviews";

	public static final String GEOGEBRA_EXPLANATION = "Geogebra";

	public static final String GEOGEBRA = "Geogebra";

	public static final String HIDE = "Hide";

	public static final String HIDE_DEMONSTRATION_CONFIRM_MESSAGE = "Hide demonstration confirm msg";

	public static final String POLLS = "Polls";

	public static final String NEW_POLL = "New poll";

	public static final String CREATE_NEW_POLL_INSTANCE = "Create new poll instance";

	public static final String POLL_TEMPLATES = "Poll templates";

	public static final String NEW_POLL_TEMPLATE = "New poll template";

	public static final String ANSWERS = "Answers";

	public static final String SHOW_RESULTS = "Show results";

	public static final String SMALL = "Small";

	public static final String MEDIUM = "Medium";

	public static final String LARGE = "Large";

	public static final String SDMATHEDITOR = "SD Math editor";

	public static final String SDMATHEDITOR_EXPLANATION = "Free form math editor area";

	public static final String TITLE = "Title";

	public static final String CHOICES = "Choices";

	public static final String POLL_DOESNT_INCLUDE_REQUIRED_INFO = "The poll doesn't include all the required information";

	public static final String EDIT_POLL_TEMPLATE = "Edit poll template";

	public static final String NEW_POLL_INSTANCE = "New poll instance";

	public static final String POLL_RESULTS = "Poll results";

	public static final String EDIT_POLL = "Edit poll";

	public static final String PERCENTAGES = "Percentages";

	public static final String POLL_MINUTES = "poll_minutes";

	public static final String POLL_DAYS = "poll_days";

	public static final String POLL_HOURS = "poll_hours";

	public static final String POLL_IS_OPEN_FOR = "The poll is open for";

	public static final String WALL = "Wall";

	public static final String ANSWER_SAVED = "Answer saved";

	public static final String UNDO = "Undo";

	public static final String REDO = "Redo";

	public static final String RESTRICTED_EDIT_MODE_DRAG_MESSAGE = "Restricted edit mode drag msg";

	public static final String FORUM_CANCEL = "FORUM.cancel";

	public static final String FORUM_COMMENT = "FORUM.comment";

	public static final String FORUM_START_A_NEW_CONVERSATION = "FORUM.startANewTopic";

	public static final String SHOW_STARS = "Show stars";

	public static final String DISABLE_NAVIGATION = "Disable navigation";

	public static final String SHOW_COURSE_IN_PREVIEW_MODE = "Show course in preview mode";

	public static final String SHOW_EXAM_IN_PREVIEW_MODE = "Show exam in preview mode";

	public static final String CONFIRM_FINISH_EXAM = "Confirm finish exam";

	public static final String CONFIRM_POLL_FOLDER_DELETE = "Confirm poll folder delete";

	public static final String CONFIRM_POLL_FOLDER_DELETE_QUESTION = "Confirm poll folder delete question";

	public static final String CONFIRM_POLL_DELETE = "Confirm poll delete";

	public static final String CONFIRM_POLL_DELETE_QUESTION = "Confirm poll delete question";

	public static final String CONVERSATION = "Conversations and Events";

	public static final String MP_TENPAIR = "Ten pair";

	public static final String ERROR_USED_SYSTEM_OUT = "Using System.out is not allowed in the robot exercise.";

	public static final String ILLEGAL_ROBOT_COMMAND = "Illegal command in the robot exercise";

	public static final String FORUM = "Forum";

	public static final String FORUM_DESCRIPTION = "Forum description";

	public static final String INBOX_HAS_NO_MESSAGES = "There are no messages in the inbox.";

	public static final String OUTBOX_HAS_NO_MESSAGES = "There are no messages in the outbox. Compose a new message to add one.";

	public static final String FEEDBACK = "Feedback";

	public static final String SELECT_MULTIPLE_OPTIONS = "Select multiple options";

	public static final String CORRECT_OPTION = "Correct option";

	public static final String INVALID_URL = "Invalid url";

	public static final String FIRST_NAME = "First name";

	public static final String LAST_NAME = "Last name";

	public static final String ERROR_UNABLE_DELETE_EVALUATIONSET = "Unable to delete evaluation set.";

	public static final String REGISTRATION_INFO = "Registration info";

	public static final String REGISTRATION_INFO_DESC = "Registration info desc";

	public static final String EXERCISE_FINISHED = "Exercise finished";

	public static final String WHATS_THIS = "What's this?";

	public static final String EXERCISE_FINISHED_EXPLANATION = "Exercise finished explanation";

	public static final String EXERCISE_NOT_FINISHED = "Exercise not finished";

	public static final String EXERCISE_NOT_FINISHED_EXPLANATION = "Exercise not finished explanation";

	public static final String CANT_HIDE_EXERCISE_IN_USE = "Can't hide exercise in use";

	public static final String CANT_HIDE_EXERCISE_IN_USE_EXPLANATION = "Can't hide exercise in use explanation";

	public static final String SHOW_POLL_RESULTS = "Show poll results";

	public static final String INCLUDE_POLL_ANSWERS_TO_SCORE = "Include poll answers to score";

	public static final String QUESTION_QUIT_WITHOUT_SAVING_CHANGES = "Quit without saving changes?";

	public static final String QUESTION_CONTINUE_WITHOUT_SAVING_CHANGES = "Continue without saving changes?";

	public static final String UNSAVED_CHANGES = "Unsaved changes";

	public static final String HAKA_USER = "HAKA user";

	public static final String ENABLE_SPELLCHECK = "Enable spellcheck in comment fields.";

	public static final String FORUMS_TAGS_CAPTION = "Forum's tags: ";

	public static final String QUERY_RETURNED_NO_ROWS = "The query returned no rows.";

	public static final String AMENU_SAIKKU = "SAIKKUEXER.NAME";

	public static final String AMENU_SAIKKU_DESC = "SAIKKUEXER.DESC";

	public static final String ADD_NEW_ASSIGNMENT_CAPTION = "Add a new assignment";

	public static final String OPERATIONEDITOR_EDITOR_DESC = "Add student's simplification assignments, each on their own line, on the lines below.";

	public static final String VALUES_ON_ROW_N_DO_NOT_EVALUATE_PROPERLY = "Values on row @0 do not evaluate properly.";

	public static final String SHUFFLE = "SHUFFLE";

	/* SYSTEM ERRORS */
	public static final String COMMUNICATION_ERROR_CAPTION = "Communication problem";
	public static final String SESSION_EXPIRED_ERROR_CAPTION = "Your session has expired.";
	public static final String AUTHENTICATION_ERROR_CAPTION = "Authentication problem";
	public static final String OUT_OF_SYNC_ERROR_CAPTION = "Synchronization problem";
	public static final String INTERNAL_ERROR_CAPTION = "An error happened";
	public static final String COOKIES_DISABLED_ERROR_CAPTION = "You have cookies disabled";

	public static final String COMMUNICATION_ERROR_TEXT = "ViLLE server can't be reached at the moment. Please check your internet connection!";
	public static final String SESSION_EXPIRED_ERROR_TEXT = "Due to security reasons your session expires after 30 minutes of idle time. Restart ViLLE by clicking this message.";
	public static final String AUTHENTICATION_ERROR_TEXT = "There was a problem in validating your authentication. Please click this message to try again!";
	public static final String OUT_OF_SYNC_ERROR_TEXT = "ViLLE server and your session seem to be out of sync. Please click this message to fix the problem!";
	public static final String INTERNAL_ERROR_TEXT = "There was an unexpected error. Click this message to try again. If the error reoccurs, please contact villeteam@utu.fi.";
	public static final String COOKIES_DISABLED_ERROR_TEXT = "It seems that you have disabled cookies in your browser. To use ViLLE, please enable cookies and reload this page.";
	/* SYSTEM ERRORS END */

	public static final String UNSAVED_CHANGES_CONFIRM_EXIT = "Unsaved changes confirm exit";

	public static final String ERROR_NOT_IMAGE_FILE = "Error not image file";

	public static final String SHOW_STUDENTS_W_SUBMISSIONS = "Show only students with submissions";

	public static final String EXERCISE_ADDED_TO_COURSE = "Exercise added to course";

	public static final String COURSE_HAS_PRIVATE_MATERIAL_DESC = "Private materials are NOT visible to the other teachers even if they copy the course";
	public static final String COURSE_HAS_PRIVATE_MATERIAL = "Course includes some private materials";

	public static final String FAQ = "FAQ";

	public static final String YOU_HAVE_UNREAD_MAILS = "You have unread messages";

	public static final String STUDENTS_PER_GROUP = "Students per group";

	public static final String UNSUPPORTED_BROWSER = "The internet browser you are using is not fully compatible with some of the features in ViLLE";
	public static final String UNSUPPORTED_BROWSER_DESC = "To provide the smoothest experience possible, I recommend using a different browser, such as Chrome or Firefox";
	public static final String UNSUPPORTED_RESOLUTION = "The height and/or width of this browser window is less than the recommended size";
	public static final String UNSUPPORTED_RESOLUTION_DESC = "My recommendation is at least 1024x768 pixels. This minimum resolution allows me to provide you with an enjoyable ViLLE-experience";

	public static final String CLICK_HERE_TO_CLOSE_MESSAGE = "Click here to hide this message";

	public static final String MANUAL_MARKER = "List of markers";
	public static final String MANUAL_QUESTION = "List of questions";

	public static final String CONCATENATE_NAME = "Concatenate name to one column";

	public static final String MP_SPECIAL_ATTENTION_STUDENTS = "Students that need special attention";

	public static final String SHOW_ALL_ROUNDS = "SHOW ALL ROUNDS";

	public static final String NO_MANUAL_QUESTIONS_ADDED = "You haven't added any manual questions";

	public static final String LOGIN_WITH_LDAP = "Login with LDAP";

	public static final String POLLS_DESCRIPTION = "Polls description";

	public static final String VOTING_CALCULATOR_INFO = "Voting calculator info";

	public static final String ACTIVATE = "ACTIVATE";

	public static final String CASE = "Case";

	public static final String COURSE_MAIN_FORUM_SELECT_CAPTION = "Course forum on mobile:";

	public static final String NO_SELECTION = "None";

	public static final String DOWNLOAD_REPORT = "Download report";

	public static final String ATTENDANCE_NAME_TOO_LONG = "ATTENDANCE_NAME_TOO_LONG";

	public static final String COURSE_OVERVIEW = "COURSE_OVERVIEW";

	public static final String USE_EXTERNAL_REGISTER_OPTION = "Use an external authentication option.";

	public static final String FIRST_ENTER_COURSE_KEY = "First, enter the course key to enable registration fields.";

	public static final String ENTER_COURSE_KEY = "Enter the course key.";

	public static final String CREATE_NEW_USER = "Create a new ViLLE user!";

	public static final String DONT_HAVE_ACCOUNT = "Don't have an account?";

	public static final String AUTHENTICATE_YOURSELF_BY_EXTERNAL_SERVICE = "You may authenticate yourself with these external service even if you are first time in ViLLE";

	public static final String COURSE_KEY_CORRECT = "Correct course key!";

	public static final String REGISTER_TO_COURSE = "Register to Course: @0";

	public static final String UPLOAD_SUCCESS = "Upload done";

	public static final String MY_PUBLIC_FILES = "My public files";

	public static final String ARE_YOU_SURE_TO_DELETE_FILE = "Are you sure to delete this file?";

	public static final String NEW_MASTER_COURSE = "New master course";

	public static final String TEMPLATE = "Template";

	public static final String ERROR_CANT_DELETE_TEMPLATE = "You may not delete this template";

	public static final String ONE_NUMBER_IS_WHOLE_NUMBER = "One number in a calculation is a whole number";

	public static final String MIN_MAX_NATURAL_NUMBER = "Min and max of the whole number";

	// private static final String PREFIX = "MATH.";
	private static final String PREFIX = "";

	/*
	 * ***
	 * 
	 * Type names and descriptions
	 * 
	 * ***
	 */

	public static final String MATH_AUDIO_ARITHMETIC_NAME = PREFIX
			+ "Math audio arithmetic";

	public static final String MATH_AUDIO_ARITHMETIC_DESC = PREFIX
			+ "Math audio arithmetic desc";

	public static final String MATH_POLYNOMIAL_NAME = PREFIX
			+ "Solving quadratic equations";

	public static final String MATH_POLYNOMIAL_DESC = PREFIX
			+ "The exercise type trains the usage of solution formula for the quadratic equations.";

	public static final String MATH_INEQUALITY_NAME = PREFIX
			+ "Inequality equations and sign charts";
	public static final String MATH_INEQUALITY_DESC = PREFIX
			+ "Inequality equations and sign charts desc";

	public static final String MATH_DERIVATION_NAME = PREFIX
			+ "Calculation rules for derivatives";

	public static final String MATH_DERIVATION_DESC = PREFIX
			+ "Training of different calculation rules for derivation, special emphasis on derivation of products, rational functions and composite functions, that can be dissected to smaller pieces.";

	public static final String MATH_MULTIPLY_NAME = PREFIX + "Multiplication";

	public static final String MATH_MULTIPLY_DESC = PREFIX
			+ "Practise multiplication against the clock. Multiplications with numbers between 0-12.";

	// MATH_CONTINUENL

	public static final String MATH_CONTINUENL_NAME = PREFIX
			+ "Fill the sequence";

	public static final String MATH_CONTINUENL_DESC = PREFIX
			+ "Fill in the wholes in sequence.";

	// MATH_FORMCALCULATION

	public static final String MATH_FORM_CALC_NAME = PREFIX + "What's missing?";

	public static final String MATH_FORM_CALC_DESC = PREFIX
			+ "Figure out what number is missing from calculation. Drag and drop the correct number or numbers to the answer area.";

	// MATH_BUILDNUMBER

	public static final String MATH_BUILD_NUMBER_NAME = PREFIX + "Build number";

	public static final String MATH_BUILD_NUMBER_DESC = PREFIX
			+ "Build asked number with the pieces provided.";

	// MATH_EQUALAMOUNT

	public static final String MATH_EQUAL_AMOUNT_NAME = PREFIX
			+ "Combine equal items";

	public static final String MATH_EQUAL_AMOUNT_DESC = PREFIX
			+ "Can you pick up equal items? Drag and drop them in to the answer area.";

	// MATH_WHATNUMBER

	public static final String MATH_WHAT_NUMBER_NAME = PREFIX
			+ "Recognize the number";

	public static final String MATH_WHAT_NUMBER_DESC = PREFIX
			+ "Recognize the number visualized by items, 10-base boxes, currency or some other form.";

	// MATH_DDNUMBERLINEEXER

	public static final String MATH_DDNUMBER_LINE_NAME = PREFIX
			+ "Drag and drop numbers to number line";

	public static final String MATH_DDNUMBER_LINE_DESC = PREFIX
			+ "Can you find the right places for the numbers on number line?";

	// MATH_NUMBERLINEEXER

	public static final String MATH_NUMBER_LINE_NAME = PREFIX + "Number line";

	public static final String MATH_NUMBER_LINE_DESC = PREFIX
			+ "What number is hiding between two given values?";

	// MATH_LONGDIVISION

	public static final String MATH_LONG_DIVISION_NAME = PREFIX
			+ "Long division";

	public static final String MATH_LONG_DIVISION_DESC = PREFIX
			+ "Practise long division.";

	// MATH_CALCROW

	public static final String MATH_CALCROW_NAME = PREFIX
			+ "Calculate in a row";

	public static final String MATH_CALCROW_DESC = PREFIX
			+ "Sum, subtract or multiply. It is easier in a row. You can also hide the values and try to figure out what is missing.";

	// MATH_CALCORDER
	public static final String MATH_CALCORDER_NAME = PREFIX
			+ "MATH_CALCORDER_NAME";

	public static final String MATH_CALCORDER_DESC = PREFIX
			+ "MATH_CALCORDER_DESC";

	// MATH_GEOMETRY

	public static final String MATH_GEOMETRY_NAME = PREFIX
			+ "MATH_GEOMETRY_NAME";

	public static final String MATH_GEOMETRY_DESC = PREFIX
			+ "MATH_GEOMETRY_DESC";

	// MATH_WHOLENUMBER

	public static final String MATH_WHOLENUMBER_NAME = PREFIX + "Calculate";

	public static final String MATH_WHOLENUMBER_DESC = PREFIX
			+ "Sum, subtraction and multiplication with natural numbers. If you are calculating with three terms, don't forget the correct calculation order.";

	// MATH_DECIMAL

	public static final String MATH_DECIMAL_NAME = PREFIX
			+ "Calculate decimals";

	public static final String MATH_DECIMAL_DESC = PREFIX
			+ "Select or write the answer of the calculation.";

	// MATH_CHART

	public static final String MATH_CHART_NAME = PREFIX + "Bar chart exercise";

	public static final String MATH_CHART_DESC = PREFIX
			+ "Read the values from bar chart and calculate decimal calculations. Can you figure out if it is a sum or subtraction?";

	// MATH_CALCFRACTIONS

	public static final String MATH_CALC_FRACS_NAME = PREFIX
			+ "Calculate fractions";

	public static final String MATH_CALC_FRACS_DESC = PREFIX
			+ "Sum, subtraction, multiplication and division of fractions.";

	// MATH_CONVERT_FRACTIONS

	public static final String MATH_CONVERT_FRACS_NAME = PREFIX
			+ "Convert fractions to decimals and decimals to fractions";

	public static final String MATH_CONVERT_FRACS_DESC = PREFIX
			+ "Convert decimals to fractions and other way around. Conversion can be made by selecting the correct decimal or by writing the correct answer.";

	public static final String MATH_CHART_NATURAL_NAME = PREFIX
			+ "Math chart natural";

	public static final String MATH_CHART_NATURAL_DESC = PREFIX
			+ "Math chart desc";

	public static final String MATH_FIRST_DEGREE_NAME = PREFIX
			+ "First degree equations";

	public static final String MATH_FIRST_DEGREE_DESC = PREFIX
			+ "First degree equations desc";

	/*
	 * ***
	 * 
	 * "In-type" constants
	 * 
	 * ***
	 */

	public static final String MATH_CHART = PREFIX + "Math chart";

	public static final String MATH_DECIMAL = PREFIX + "Math decimal";

	public static final String EXPLANATION_MATH_CHART = PREFIX
			+ "Explanation math chart";

	public static final String EXPLANATION_MATH_DECIMAL = PREFIX
			+ "Explanation math decimal";

	public static final String MATH_CONVERT_FRACTIONS = PREFIX
			+ "Math convert fractions";

	public static final String EXPLANATION_MATH_CONVERT_FRACTIONS = PREFIX
			+ "Explanation math convert fractions";

	public static final String MATH_PREV = PREFIX + "Previous math question";
	public static final String MATH_CHECK = PREFIX + "Check your answer";
	public static final String MATH_NEXT = PREFIX + "Next math question";

	/* Einari's localizations */
	public static final String MATH_EXER_CHART = PREFIX
			+ "Reading from chart and calculating";
	public static final String BUILD_NUMBER = PREFIX + "Construct a number";
	public static final String CALC_DECIMAL = PREFIX
			+ "Calculating with decimals";
	public static final String CALC_FRACTIONS = PREFIX
			+ "Calculating with fractions";
	public static final String CALC_ROW = PREFIX + "Calculating in a row";
	public static final String CALC_WHOLEN = PREFIX
			+ "Calculating with wholenumbers";
	public static final String CONVERT_FRACTIONS = PREFIX
			+ "Convert fractions and decimals";
	public static final String DDNUMBERLINE = PREFIX + "Sort numbers";
	public static final String MULTIPLY = PREFIX + "Practising multiplication";
	public static final String MATH_NUMBERLINE = PREFIX + "Numberline";
	public static final String WHATNUMBER = PREFIX + "What number is this?";

	public static final String USE_VISUALIZATION = PREFIX
			+ "Use visualization, recommended with small values.";
	public static final String CHOOSE_TO_ANSWER = PREFIX + "Answer by choosing";
	public static final String ONLY_DECIMALS = PREFIX
			+ "Only decimals (not 1 for example)";

	public static final String MATH_HEIGHTS = PREFIX + "Heights";
	public static final String MATH_SETTINGS = PREFIX + "Settings";
	public static final String MATH_MINVALUE = PREFIX + "Minimum";
	public static final String MATH_MAXVALUE = PREFIX + "Maximum";
	public static final String MATH_ANSWERMAX = PREFIX + "Max. answer";
	public static final String MATH_ANSWERMIN = PREFIX + "Min. answer";
	public static final String MATH_AMOUNT = PREFIX + "Amount of questions";
	public static final String MATH_NAMES = PREFIX + "Names";
	public static final String MATH_STORY = PREFIX
			+ "Once up on a time there was a forrest, where lived a lot of ants. On of the anthills were living ants called";
	public static final String MATH_CHART_ANSWER = PREFIX
			+ ". Answer questions using the bar chart.";
	public static final String MATH_WRITE_STORY = PREFIX + "Write story";
	public static final String SAME_DENOMINATOR = PREFIX + "Same denominator";
	public static final String SMALLER_THAN_ONE = PREFIX
			+ "Calculating with nubmers smaller than one";

	public static final String OPERATION_SUM = PREFIX + "Sum";
	public static final String OPERATION_SUBT = PREFIX + "Subtraction";
	public static final String OPERATION_DIV = PREFIX + "Division";

	public static final String VISUAL_OBJECTS = PREFIX + "Objects";
	public static final String VISUAL_MIX_COLOR = PREFIX
			+ "Mix the color of objects";
	public static final String VISUAL_BOXES = PREFIX + "10-base boxes";
	public static final String VISUAL_WRITTEN = PREFIX + "Written";
	public static final String VISUAL_NUMBER = PREFIX + "Number";
	public static final String VISUAL_FRACTION = PREFIX + "Fraction";
	public static final String VISUAL_MONEY = PREFIX + "Money";
	public static final String VISUAL_CHOOSE = PREFIX + "Choose visualization";

	public static final String ANSWER_CORRECT = PREFIX + "Correct!";
	public static final String ANSWER_WRONG = PREFIX
			+ "Just a little more precision";
	public static final String GIVEN_ANSWER = PREFIX + "Your answer";
	public static final String FEEDBACK_CORRECT = PREFIX + "Correct answer";
	public static final String MATH_TENTH = PREFIX + "Tenths";
	public static final String MATH_UNITS = PREFIX + "Units";
	public static final String MATH_TENS = PREFIX + "Tens";
	public static final String MATH_HUNDREDS = PREFIX + "Hundreds";
	public static final String MATH_U = PREFIX + "U";
	public static final String MATH_T = PREFIX + "T";
	public static final String MATH_H = PREFIX + "H";
	public static final String MATH_TH = PREFIX + "TH";
	public static final String MATH_TTH = PREFIX + "TTH";
	public static final String MATH_HTH = PREFIX + "HTH";

	public static final String MATH_THOUSANDS = PREFIX + "Thousands";
	public static final String MATH_TENTHOUSANDS = PREFIX + "Tens thousands";
	public static final String MATH_HUNDREDTHOUSANDS = PREFIX
			+ "Hundred thousands";
	public static final String MATH_MILLIONS = PREFIX + "Millions";
	public static final String END_OF_THE_UNIVERSE = PREFIX
			+ "Thou shall not divide by zero!";

	public static final String MATH_WRITE_EQ = PREFIX + "Write an equation";
	public static final String CHART_LONGER = PREFIX + "How much longer is";
	public static final String CHART_TOGETHER = PREFIX
			+ "How long are together";
	public static final String MATH_AND = PREFIX + "and";
	public static final String MATH_THAN = PREFIX + "than";
	public static final String MATH_LENGTH = PREFIX + "'s length";

	public static final String MEMORY_NUMBER = PREFIX + "Use memory numbers";
	public static final String MULTIPLIER_TWO = PREFIX
			+ "Use multiplier with two digits";
	public static final String MULTIPLIER_ONE = PREFIX
			+ "Use multiplier with one digit";

	public static final String MATH_HIDE = PREFIX
			+ "Fill in the holes, hide numbers";
	public static final String MATH_HIDE_TWO = PREFIX
			+ "Fill in the holes, hide two numbers";
	public static final String STEP_BY_STEP = PREFIX
			+ "Calculating step by step";
	public static final String MATH_THREE_TERMS = PREFIX + "Three terms";

	public static final String NL_MODIFY_MAX = PREFIX
			+ "Add/remove/multiply/divide number up to";
	public static final String NL_MODIFY_MIN = PREFIX
			+ "Add/remove/multiply/divide number at least";
	public static final String NL_LENGTH = PREFIX + "Length of the numberline";
	public static final String NL_HOLES = PREFIX + "Number of the holes";
	public static final String NL_MIX = PREFIX + "Mix the places of the holes";
	public static final String NL_CONTINUE = PREFIX + "Continue numberline";

	public static final String F2D = PREFIX + "Fraction to decimal";
	public static final String D2F = PREFIX + "Decimal to fraction";

	public static final String MATH_CHOSEN = PREFIX + "Selected";
	public static final String MATH_NMBR_SORT = PREFIX
			+ "Amount of numbers to be sorted";
	public static final String MATH_MAGNITUDE = PREFIX + "Magnitude";

	public static final String NUMBER_OF_BOXES = PREFIX + "Number of boxes";
	public static final String MATH_COMBINE = PREFIX
			+ "Combine equal items into the box below";

	public static final String MATH_NEED_ADD = PREFIX
			+ "What needs to be added into";
	public static final String MATH_FILL_IN_THE_HOLE = PREFIX
			+ "Fill in the hole using numbers below";
	public static final String MATH_TOGET = PREFIX + "to get number";

	public static final String MATH_TENPAIRS = PREFIX + "Practise ten-pairs";
	public static final String MATH_FILL_BLANKS = PREFIX + "Fill in the blanks";
	public static final String MATH_VISUALIZE_QUESTION = PREFIX
			+ "Visualize question";
	public static final String MATH_USE_DRAG_AND_DROP = PREFIX
			+ "Use drag and drop to answer";

	public static final String MATH_DIVIDER = PREFIX + "Divider";
	public static final String MATH_REMINDER = PREFIX + "Reminder";
	public static final String MATH_EVEN_DIV = PREFIX
			+ "Division turns out even";
	public static final String MATH_NMB_SUBT = PREFIX
			+ "Amount of subtractions";

	public static final String MATH_TIME = PREFIX + "Time (s)";
	public static final String MATH_CALC_CORR = PREFIX + "Calculations correct";
	public static final String MULTIPLY_CALC = PREFIX
			+ "Calculate multiplications";
	public static final String MULTIPLY_CORR = PREFIX
			+ "Well done! You managed to calculate all the multiplications. Press check.";
	public static final String MULTIPLY_WRONG = PREFIX
			+ "Let's practise some more. Submit and try again.";
	public static final String MULITPLY_CONTINUE = PREFIX
			+ "Well done! You can continue forward.";

	public static final String MULTIPLY_CALCULATION = PREFIX + "Calculation";
	public static final String MULTIPLY_ANSWER = PREFIX + "Answer";
	public static final String MULTIPLY_CHECK = PREFIX + "Check";
	public static final String MULTIPLY_YOUGOT = PREFIX + "You got";
	public static final String MULTIPLY_USED_TIME = PREFIX + "and used";

	public static final String MATH_SECONDS = PREFIX + "s";
	public static final String ANSWER_EMPTY = PREFIX + "Empty answer";
	public static final String MATH_GREATERTHAN = PREFIX
			+ "What number is greather than";
	public static final String MATH_SMALLERTHAN = PREFIX + "but smaller than";
	public static final String MATH_THRESHOLD = PREFIX
			+ "Threshold of the numbers asked";

	public static final String EASY = "Easy";
	public static final String MODERATE = "Moderate";
	public static final String HARD = "Hard";
	
	public static final String LEVEL_EASY = PREFIX + "Warm up";
	public static final String LEVEL_NORMAL = PREFIX + "Ok, I'm ready";
	public static final String LEVEL_HARD = PREFIX + "Is that all you got?";

	public static final String EXERCISE_NOT_READY_FOR_SAVING_OR_TESTING = "Current exercise is not ready for testing or saving. Please fill in all exercise settings.";
	
	/* Quadratic equation exercise */
	public static final String EQUATION_GROUP_CAPTION = PREFIX + "Equation";
	public static final String EQUATION_HAS_TWO_REAL_ROOTS = PREFIX
			+ "Equation has two real roots.";
	public static final String EQUATION_HAS_ONE_REAL_ROOT = PREFIX
			+ "Equation has one real root.";
	public static final String EQUATION_HAS_NO_REAL_ROOTS = PREFIX
			+ "Equation has no real roots.";
	public static final String THE_ROOTS_ARE = PREFIX + "Roots are:";
	public static final String THE_ROOT_IS = PREFIX + "Root is:";
	public static final String QUADRATIC_EQUATION_MODEL_SOLUTION = PREFIX
			+ "Quadratic equation solution";
	public static final String QUADRATIC_EQUATION_MODEL_SOLUTION_EXTENSION1 = PREFIX
			+ "Quadratic equation solution appendix 1";
	public static final String QUADRATIC_EQUATION_MODEL_SOLUTION_EXTENSION2 = PREFIX
			+ "Quadratic equation solution appendix 2";
	public static final String HAS_TWO_REAL_ROOTS = PREFIX
			+ "has two real roots";
	public static final String HAS_ONE_REAL_ROOT = PREFIX + "has one real root";
	public static final String HAS_NO_REAL_ROOTS = PREFIX + "has no real roots";

	/* Quadratic equation editor */
	public static final String CAPTION_EQUATIONS_WITH_TWO_REAL_ROOTS = PREFIX
			+ "Equations with two real roots.";
	public static final String CAPTION_EQUATIONS_WITH_ONE_REAL_ROOT = PREFIX
			+ "Equations with one real root.";
	public static final String CAPTION_EQUATIONS_WITH_NO_REAL_ROOTS = PREFIX
			+ "Equations with no real roots.";
	public static final String CAPTION_EQUATIONS_WITH_TERMS_OF_ALL_DEGREES = PREFIX
			+ "Equations with terms of all degrees.";
	public static final String CAPTION_EQUATIONS_WITH_FIRST_DEGREE_TERM_MISSING = PREFIX
			+ "Equations with first degree term missing.";
	public static final String CAPTION_EQUATIONS_WITH_CONSTANT_TERM_MISSING = PREFIX
			+ "Equations with constant term missing.";
	public static final String CAPTION_FIRST_ROOT_RANGE_MIN = PREFIX
			+ "First root range minimum:";
	public static final String CAPTION_FIRST_ROOT_RANGE_MAX = PREFIX
			+ "First root range maximum:";
	public static final String CAPTION_SECOND_ROOT_RANGE_MIN = PREFIX
			+ "Second root range minimum:";
	public static final String CAPTION_SECOND_ROOT_RANGE_MAX = PREFIX
			+ "Second root range maximum:";
	public static final String CAPTION_PARTIAL_CASES = PREFIX
			+ "Partial cases:";
	public static final String CAPTION_ROOT_TYPES = PREFIX + "Root types:";
	public static final String CAPTION_GENERAL = PREFIX + "General:";
	public static final String CALCULATE_ROOTS_FOR_EQUATION = PREFIX
			+ "What are the roots for given equation?";
	public static final String CAPTION_AMOUNT_OF_REPETITIONS = PREFIX
			+ "Amount of repetitions:";
	public static final String CAPTION_AMOUNT_OF_ROOTS = PREFIX
			+ "Amount of roots:";
	public static final String INTEGERS = PREFIX + "Integers";
	public static final String RATIONAL_NUMBERS = PREFIX + "Rational numbers";
	public static final String DECIMAL_NUMBERS = PREFIX + "Decimal numbers";
	public static final String SQUARE_ROOTS = PREFIX + "Square roots";
	public static final String SELECT_AT_LEAST_ONE_ROOT = PREFIX
			+ "SELECT_AT_LEAST_ONE_ROOT";
	public static final String ALWAYS_EXPAND_POLYNOMIALS = PREFIX
			+ "Always expand polynomials.";
	public static final String QUADRATIC_EQUATION_EXERCISE_EDITOR_HELP_PAGE = PREFIX
			+ "<h1 class=\"color-h1\">Quadratic equation exercise</h1>";

	/**** Help texts for editor ****/

	public static final String HELP_BUILDNUMBER = PREFIX + "HELP_BUILDNUMBER";
	public static final String HELP_BUILDNUMBER_LEFT = PREFIX
			+ "HELP_BUILDNUMBER_LEFT";
	public static final String HELP_BUILDNUMBER_CENTER = PREFIX
			+ "HELP_BUILDNUMBER_CENTER";
	public static final String HELP_BUILDNUMBER_RIGHT = PREFIX
			+ "HELP_BUILDNUMBER_RIGHT";

	public static final String HELP_CALCCHART = PREFIX + "HELP_CALCCHART";
	public static final String HELP_CALCCHART_LEFT = PREFIX
			+ "HELP_CALCCHART_LEFT";
	public static final String HELP_CALCCHART_CENTER = PREFIX
			+ "HELP_CALCCHART_CENTER";
	public static final String HELP_CALCCHART_RIGHT = PREFIX
			+ "HELP_CALCCHART_RIGHT";

	public static final String HELP_CALCCHARTNN = PREFIX + "HELP_CALCCHARTNN";
	public static final String HELP_CALCCHARTNN_LEFT = PREFIX
			+ "HELP_CALCCHARTNN_LEFT";
	public static final String HELP_CALCCHARTNN_CENTER = PREFIX
			+ "HELP_CALCCHARTNN_CENTER";
	public static final String HELP_CALCCHARTNN_RIGHT = PREFIX
			+ "HELP_CALCCHARTNN_RIGHT";

	public static final String HELP_CALCDECIMAL = PREFIX + "HELP_CALCDECIMAL";
	public static final String HELP_CALCDECIMAL_LEFT = PREFIX
			+ "HELP_CALCDECIMAL_LEFT";
	public static final String HELP_CALCDECIMAL_CENTER = PREFIX
			+ "HELP_CALCDECIMAL_CENTER";
	public static final String HELP_CALCDECIMAL_RIGHT = PREFIX
			+ "HELP_CALCDECIMAL_RIGHT";

	public static final String HELP_CALCFRACTIONS = PREFIX
			+ "HELP_CALCFRACTIONS";
	public static final String HELP_CALCFRACTIONS_LEFT = PREFIX
			+ "HELP_CALCFRACTIONS_LEFT";
	public static final String HELP_CALCFRACTIONS_CENTER = PREFIX
			+ "HELP_CALCFRACTIONS_CENTER";
	public static final String HELP_CALCFRACTIONS_RIGHT = PREFIX
			+ "HELP_CALCFRACTIONS_RIGHT";

	public static final String HELP_CALCROW = PREFIX + "HELP_CALCROW";
	public static final String HELP_CALCROW_LEFT = PREFIX + "HELP_CALCROW_LEFT";
	public static final String HELP_CALCROW_CENTER = PREFIX
			+ "HELP_CALCROW_CENTER";
	public static final String HELP_CALCROW_RIGHT = PREFIX
			+ "HELP_CALCROW_RIGHT";

	public static final String HELP_CALCWHOLENUMBER = PREFIX
			+ "HELP_CALCWHOLENUMBER";
	public static final String HELP_CALCWHOLENUMBER_LEFT = PREFIX
			+ "HELP_CALCWHOLENUMBER_LEFT";
	public static final String HELP_CALCWHOLENUMBER_CENTER = PREFIX
			+ "HELP_CALCWHOLENUMBER_CENTER";
	public static final String HELP_CALCWHOLENUMBER_RIGHT = PREFIX
			+ "HELP_CALCWHOLENUMBER_RIGHT";

	public static final String HELP_CONTINUENL = PREFIX + "HELP_CONTINUENL";
	public static final String HELP_CONTINUENL_LEFT = PREFIX
			+ "HELP_CONTINUENL_LEFT";
	public static final String HELP_CONTINUENL_CENTER = PREFIX
			+ "HELP_CONTINUENL_CENTER";
	public static final String HELP_CONTINUENL_RIGHT = PREFIX
			+ "HELP_CONTINUENL_RIGHT";

	public static final String HELP_CONVERTFRACTIONS = PREFIX
			+ "HELP_CONVERTFRACTIONS";
	public static final String HELP_CONVERTFRACTIONS_LEFT = PREFIX
			+ "HELP_CONVERTFRACTIONS_LEFT";
	public static final String HELP_CONVERTFRACTIONS_CENTER = PREFIX
			+ "HELP_CONVERTFRACTIONS_CENTER";
	public static final String HELP_CONVERTFRACTIONS_RIGHT = PREFIX
			+ "HELP_CONVERTFRACTIONS_RIGHT";

	public static final String HELP_DDNUMBERLINE = PREFIX + "HELP_DDNUMBERLINE";
	public static final String HELP_DDNUMBERLINE_LEFT = PREFIX
			+ "HELP_DDNUMBERLINE_LEFT";
	public static final String HELP_DDNUMBERLINE_CENTER = PREFIX
			+ "HELP_DDNUMBERLINE_CENTER";
	public static final String HELP_DDNUMBERLINE_RIGHT = PREFIX
			+ "HELP_DDNUMBERLINE_RIGHT";

	public static final String HELP_EQUALAMOUNT = PREFIX + "HELP_EQUALAMOUNT";
	public static final String HELP_EQUALAMOUNT_LEFT = PREFIX
			+ "HELP_EQUALAMOUNT_LEFT";
	public static final String HELP_EQUALAMOUNT_CENTER = PREFIX
			+ "HELP_EQUALAMOUNT_CENTER";
	public static final String HELP_EQUALAMOUNT_RIGHT = PREFIX
			+ "HELP_EQUALAMOUNT_RIGHT";

	public static final String HELP_FORMCALCULATION = PREFIX
			+ "HELP_FORMCALCULATION";
	public static final String HELP_FORMCALCULATION_LEFT = PREFIX
			+ "HELP_FORMCALCULATION_LEFT";
	public static final String HELP_FORMCALCULATION_CENTER = PREFIX
			+ "HELP_FORMCALCULATION_CENTER";
	public static final String HELP_FORMCALCULATION_RIGHT = PREFIX
			+ "HELP_FORMCALCULATION_RIGHT";

	public static final String HELP_LONGDIVISION = PREFIX + "HELP_LONGDIVISION";
	public static final String HELP_LONGDIVISION_LEFT = PREFIX
			+ "HELP_LONGDIVISION_LEFT";
	public static final String HELP_LONGDIVISION_CENTER = PREFIX
			+ "HELP_LONGDIVISION_CENTER";
	public static final String HELP_LONGDIVISION_RIGHT = PREFIX
			+ "HELP_LONGDIVISION_RIGHT";

	public static final String HELP_MULTIPLY = PREFIX + "HELP_MULTIPLY";
	public static final String HELP_MULTIPLY_LEFT = PREFIX
			+ "HELP_MULTIPLY_LEFT";
	public static final String HELP_MULTIPLY_CENTER = PREFIX
			+ "HELP_MULTIPLY_CENTER";
	public static final String HELP_MULTIPLY_RIGHT = PREFIX
			+ "HELP_MULTIPLY_RIGHT";

	public static final String HELP_NUMBERLINEEXER = PREFIX
			+ "HELP_NUMBERLINEEXER";
	public static final String HELP_NUMBERLINEEXER_LEFT = PREFIX
			+ "HELP_NUMBERLINEEXER_LEFT";
	public static final String HELP_NUMBERLINEEXER_CENTER = PREFIX
			+ "HELP_NUMBERLINEEXER_CENTER";
	public static final String HELP_NUMBERLINEEXER_RIGHT = PREFIX
			+ "HELP_NUMBERLINEEXER_RIGHT";

	public static final String HELP_WHATNUMBER = PREFIX + "HELP_WHATNUMBER";
	public static final String HELP_WHATNUMBER_LEFT = PREFIX
			+ "HELP_WHATNUMBER_LEFT";
	public static final String HELP_WHATNUMBER_CENTER = PREFIX
			+ "HELP_WHATNUMBER_CENTER";
	public static final String HELP_WHATNUMBER_RIGHT = PREFIX
			+ "HELP_WHATNUMBER_RIGHT";

	/* * Inequality exercise * */
	public static final String INEQUALITY_QUESTION = PREFIX
			+ "Inequality question";
	public static final String IDENTICALLY_TRUE = PREFIX
			+ "\\text{Identically true.}";
	public static final String IDENTICALLY_FALSE = PREFIX
			+ "\\text{Identically false.}";
	public static final String CLEAR_THE_SIGN_CHART = PREFIX
			+ "Clear the sign chart";
	public static final String HEADER_SIGN_CHART = PREFIX + "Sign chart";
	public static final String HEADER_SOLVE_INEQUALITY = PREFIX
			+ "Solving inequalites using sign charts";

	/* * Inequality exercise, editor * */
	public static final String INEQUALITY_HELPER_STRING = PREFIX
			+ "Inequality helper string";
	public static final String LEFT_SIDE_NOMINATOR_DEGREE_CAPTION = PREFIX
			+ "Left side nominator degree:";
	public static final String LEFT_SIDE_DENOMINATOR_DEGREE_CAPTION = PREFIX
			+ "Left side denominator degree:";
	public static final String RIGHT_SIDE_NOMINATOR_DEGREE_CAPTION = PREFIX
			+ "Right side nominator degree:";
	public static final String RIGHT_SIDE_DENOMINATOR_DEGREE_CAPTION = PREFIX
			+ "Right side denominator degree:";
	public static final String EXPAND_LEFT_SIDE_NOMINATOR_CAPTION = PREFIX
			+ "Expand left side nominator polynomial.";
	public static final String EXPAND_LEFT_SIDE_DENOMINATOR_CAPTION = PREFIX
			+ "Expand left side denominator polynomial.";
	public static final String EXPAND_RIGHT_SIDE_NOMINATOR_CAPTION = PREFIX
			+ "Expand right side nominator polynomial.";
	public static final String EXPAND_RIGHT_SIDE_DENOMINATOR_CAPTION = PREFIX
			+ "Expand right side denominator polynomial.";
	public static final String LEFT_SIDE_NOMINATOR_IS_FIXED = PREFIX
			+ "Left side nominator is fixed.";
	public static final String LEFT_SIDE_DENOMINATOR_IS_FIXED = PREFIX
			+ "Left side denominator is fixed.";
	public static final String RIGHT_SIDE_NOMINATOR_IS_FIXED = PREFIX
			+ "Right side nominator is fixed.";
	public static final String RIGHT_SIDE_DENOMINATOR_IS_FIXED = PREFIX
			+ "Right side denominator is fixed.";
	public static final String FIXED_VALUE_OF_LEFT_SIDE_NOMINATOR_CAPTION = PREFIX
			+ "Fixed value of left side nominator:";
	public static final String FIXED_VALUE_OF_LEFT_SIDE_DENOMINATOR_CAPTION = PREFIX
			+ "Fixed value of left side denominator:";
	public static final String FIXED_VALUE_OF_RIGHT_SIDE_NOMINATOR_CAPTION = PREFIX
			+ "Fixed value of right side nominator:";
	public static final String FIXED_VALUE_OF_RIGHT_SIDE_DENOMINATOR_CAPTION = PREFIX
			+ "Fixed value of right side denominator:";
	public static final String EXPANSION_OF_POLYNOMIALS_GROUP_CAPTION = PREFIX
			+ "Expansion of polynomials:";
	public static final String FIXED_VALUES_GROUP_CAPTION = PREFIX
			+ "Fixed values:";

	public static final String CE_FIELD_VALUE_ERROR = PREFIX
			+ "Must be a positive integer less than @0";

	public static final String CE_BIN_TO_DEC_COUNT = PREFIX
			+ "How many binary to decimal conversions?";

	public static final String CE_BIN_TO_HEX_COUNT = PREFIX
			+ "How many binary to hexa conversions?";

	public static final String CE_DEC_TO_BIN_COUNT = PREFIX
			+ "How many decimal to binary conversions?";

	public static final String CE_DEC_TO_HEX_COUNT = PREFIX
			+ "How many decimal to hexa conversions?";

	public static final String CE_HEX_TO_BIN_COUNT = PREFIX
			+ "How many hexa to binary conversions?";

	public static final String CE_HEX_TO_DEC_COUNT = PREFIX
			+ "How many hexa to decimal conversions?";

	public static final String CE_LOW_LIMIT = PREFIX
			+ "Minimum (in decimal) for numbers used in conversions";

	public static final String CE_HIGH_LIMIT = PREFIX
			+ "Maximum (in decimal) for numbers used in conversions";

	public static final String CE_LOW_MUST_BE_POSITIVE_INTEGER_LESS_THAN_HIGH = PREFIX
			+ "Minimum must be a positive integer less than maximum";

	public static final String CE_HIGH_MUST_BE_POSITIVE_INTEGER_MORE_THAN_LOW = PREFIX
			+ "Maximum must be a positive integer greater than minimum";

	public static final String CE_BIN_TO_DEC = PREFIX
			+ "Convert from binary to decimal";

	public static final String CE_BIN_TO_HEX = PREFIX
			+ "Convert from binary to hexa";

	public static final String CE_DEC_TO_BIN = PREFIX
			+ "Convert from decimal to binary";

	public static final String CE_DEC_TO_HEX = PREFIX
			+ "Convert from decimal to hexa";

	public static final String CE_HEX_TO_BIN = PREFIX
			+ "Convert from hexa to binary";

	public static final String CE_HEX_TO_DEC = PREFIX
			+ "Convert from hexa to decimal";

	public static final String CE_NAME = PREFIX + "Conversion exercise";

	public static final String CE_DESC = PREFIX
			+ "Do conversions between decimal, hexa and binary numbers";

	public static final String BC_MULTIP_COUNT = PREFIX
			+ "How many multiplication questions?";

	public static final String BC_ADD_COUNT = PREFIX
			+ "How many addition questions?";

	public static final String BC_SUBT_COUNT = PREFIX
			+ "How many subtraction questions?";

	public static final String BC_NAME = PREFIX + "Binary calculations";

	public static final String BC_DESC = PREFIX
			+ "Do binary multiplication, addition and subtraction calculations";

	public static final String BC_HIGH_LIMIT = PREFIX
			+ "Maximum (in decimal) for numbers used in conversions (Locked for multiplications to < 15)";

	public static final String CHART = PREFIX + "Chart";

	public static final String ADD_ROW = PREFIX + "Add row";

	public static final String DELETE_ROW = PREFIX + "Delete row";

	public static final String FIRST_DEGREE_SOLVE_THE_EQUATION = PREFIX
			+ "\\text{What is the value of } x \\text{ in equation }\\\\$$\\\\@0?\\\\$$";
	public static final String FIRST_DEGREE_MODEL_SOLUTION = PREFIX
			+ "place-holder for first degree model solution";
	public static final String FIRST_DEGREE_EXERCISE_EDITOR_HELP_PAGE = PREFIX
			+ "place-holder for first degree editor help text";

	public static final String EXPLANATION_OR = PREFIX + "or";

	public static final String MOD10 = PREFIX + "Divisible by 10";
	public static final String MOD100 = PREFIX + "Divisible by 100";
	public static final String LENGTH_OF_EQUATION = PREFIX
			+ "Length of equation";
	public static final String MAKE_ALL_NUMBERS_EVEN = PREFIX
			+ "Make all numbers even";

	/* * Derivation exercise, editor * */
	public static final String DERIVATION_HELPER_STRING = PREFIX
			+ "Derivation helper string";
	public static final String DERIVATION_CAPTION_FUNCTION_TYPE_GROUP = PREFIX
			+ "Exercise types:";
	public static final String DERIVATION_CAPTION_INNER_FUNCTION_EXERCISES = PREFIX
			+ "Exercises that emphasize derivation of composite functions.";
	public static final String DERIVATION_CAPTION_PRODUCT_FUNCTION_EXERCISES = PREFIX
			+ "Exercises that emphasize derivation of product functions.";
	public static final String DERIVATION_CAPTION_RATIONAL_FUNCTION_EXERCISES = PREFIX
			+ "Exercises that emphasize derivation of rational functions.";
	public static final String DERIVATION_CAPTION_INNER_FUNCTION = PREFIX
			+ "Inner functions:";
	public static final String DERIVATION_CAPTION_OUTER_FUNCTION = PREFIX
			+ "Outer functions:";

	/* * Derivation exercise * */
	public static final String HEADER_DERIVATION_CALCULATION_RULES = PREFIX
			+ "Calculation rules for derivation";
	public static final String HEADER_SOLUTION = PREFIX + "Solution";
	public static final String HEADER_CHECKUP = PREFIX + "Checkup";
	public static final String HEADER_RESULT = PREFIX + "Result";
	public static final String FUNCTION_F_EQUALS = PREFIX + "f(x)=";
	public static final String FUNCTION_F_DERIVATIVE_EQUALS = PREFIX + "f'(x)=";
	public static final String FUNCTION_G_EQUALS = PREFIX + "g(x)=";
	public static final String FUNCTION_G_DERIVATIVE_EQUALS = PREFIX + "g'(x)=";
	public static final String FUNCTION_FG_PRODUCT_DERIVATIVE_EQUALS = PREFIX
			+ "D(f(x) \\cdot g(x))=";
	public static final String FUNCTION_FG_QUOTIENT_DERIVATIVE_EQUALS = PREFIX
			+ "D\\left(\\frac{f(x)}{g(x)}\\right)=";
	public static final String FUNCTION_FG_COMPOSITE_FUNCTION_DERIVATIVE_EQUALS = PREFIX
			+ "D(f(g(x)))=";
	public static final String DERIVATIVE_OF_FUNCTION_F_CALCULATED_CORRECTLY = PREFIX
			+ "Derivative of function f(x) is calculated correctly.";
	public static final String DERIVATIVE_OF_FUNCTION_G_CALCULATED_CORRECTLY = PREFIX
			+ "Derivative of function g(x) is calculated correctly.";
	public static final String GIVEN_DERIVATIVE_IS_NOT_EQUAL_TO_DERIVATIVE_OF_F = PREFIX
			+ "Given derivative f'(x) is not a derivative of function f(x).";
	public static final String GIVEN_DERIVATIVE_IS_NOT_EQUAL_TO_DERIVATIVE_OF_G = PREFIX
			+ "Given derivative g'(x) is not a derivative of function g(x).";
	public static final String COMPOSITE_FUNCTION_HAS_BEEN_FORMED_CORRECTLY = PREFIX
			+ "Composite function has been formed correctly.";
	public static final String GIVEN_COMPOSITE_FUNCTION_DOES_NOT_MATCH_COMPOSITE_FUNCTION_OF_F_AND_G = PREFIX
			+ "Given composite function does not match the composite function of functions f(x) and g(x).";
	public static final String GIVEN_DERIVATIVE_IS_CORRECT = PREFIX
			+ "Given derivative is correct.";
	public static final String GIVEN_DERIVATIVE_DIFFERS_FROM_PROPER_DERIVATIVE = PREFIX
			+ "Given derivative differs from proper derivative.";
	public static final String SOME_OF_THE_FIELDS_ARE_EMPTY = PREFIX
			+ "Some of the fields are empty.";
	public static final String CORRECT_ANSWER_IS = PREFIX
			+ "\\text{Correct answer is }\\\\$$\\\\@0\\\\$$\\\\";
	public static final String COMPOSITE_FUNCTION_DERIVATIVE_QUESTION = PREFIX
			+ "Composite function derivative question";
	public static final String PRODUCT_FUNCTION_DERIVATIVE_QUESTION = PREFIX
			+ "Product function derivative question";
	public static final String RATIONAL_FUNCTION_DERIVATIVE_QUESTION = PREFIX
			+ "Rational function derivative question";

	public static final String MATH_SHOWHIGHLIGHT = PREFIX
			+ "Show values in bar chart on hover";

	public static final String MATH_SHOWPOINTLABELS = PREFIX
			+ "Show values in bar chart";

	public static final String MATH_QUESTION_PLUS = PREFIX
			+ "Question when adding";

	public static final String MATH_QUESTION_MINUS = PREFIX
			+ "Question when subtracting";

	public static final String MATH_SHOW_OPERATIONS = PREFIX
			+ "Show operations";

	public static final String MATH_SHOW_NUMBERS = PREFIX + "Show numbers";
	public static final String MATH_USE_VOICE = PREFIX + "Use voice";
	public static final String MATH_SHOW_CONTINUUM_IN_ANSWER = PREFIX
			+ "Show continuum in answer";

	public static final String DIVIDER = PREFIX + "Divider";
	public static final String DIVIDEND = PREFIX + "DIVIDEND";

	public static final String DENOMINATOR = PREFIX + "Denominator";
	public static final String NUMERATOR = PREFIX + "Numerator";

	public static final String MATH_MIXED_FRACTION = PREFIX
			+ "Show as mixed fraction";

	public static final String MATH_SHOW_MY_ANSWER = PREFIX + "SHOW_MY_ANSWER";

	public static final String MATH_SHOW_CORRECT_ANSWER = PREFIX
			+ "Show correct answer";

	public static final String MATH_HERE_IS_CORRECT_ANSWER = PREFIX
			+ "Here is the correct answer";

	public static final String CHECK_SETTINGS = PREFIX + "Check given settings";

	public static final String MATH_DO_NOT_DIVID_BY_ZERO = PREFIX
			+ "Don't divide by zero";

	public static final String NO_ANSWER = PREFIX + "No answer";

	public static final String MATH_AMOUNT_OF_DECIMALS = PREFIX
			+ "Number of visible decimals";

	public static final String FEEDBACK_CORRECT_NICE_JOB = PREFIX
			+ "That's correct, nice job!";

	public static final String FEEDBACK_GOOD_JOB = PREFIX + "Good job!";

	public static final String FEEDBACK_BRILLIANT = PREFIX + "Brilliant!";

	public static final String FEEDBACK_GREAT = PREFIX + "Great!";

	public static final String FEEDBACK_OOPS_HOW_DID_THAT_HAPPEN = PREFIX
			+ "Oops, how did that happen?";

	public static final String FEEDBACK_LITTLE_MORE_PRECISION = PREFIX
			+ "A little more precision";

	public static final String FEEDBACK_BETTER_LUCK_NEXT_TIME = PREFIX
			+ "Better luck next time";

	public static final String FEEDBACK_OOPS_THAT_DIDNT_WORK = PREFIX
			+ "Oops, that didn't work";

	public static final String MATH_POINTS = PREFIX + "Points";

	public static final String MATH_TRIES = PREFIX + "Tries";

	public static final String QUESTION = PREFIX + "Question";

	public static final String ANSWERED = PREFIX + "Answered";

	public static final String CORRECT_ANSWER = PREFIX + "Correct answer";

	public static final String CORRECT = PREFIX + "Correct";

	public static final String SUBMIT = PREFIX + "Submit answers";

	public static final String CANCEL = PREFIX + "Cancel";

	public static final String GENERATE = PREFIX + "GENERATE";

	public static final String NOT_A_NUMBER_ERROR = PREFIX
			+ "NOT A NUMBER ERROR";

	public static final String NOT_A_OPERATOR_ERROR = PREFIX
			+ "NOT A OPERATOR ERROR";

	public static final String EMPTY_FIELDS_ERROR = PREFIX
			+ "EMPTY FIELDS ERROR";

	public static final String WRONG_ANSWER_ERROR = PREFIX
			+ "WRONG ANSWER ERROR";

	public static final String NOT_IN_POOL_ERROR = PREFIX + "Not in pool error";

	public static final String CALCULATION_ERROR = PREFIX + "Calculation error";

	public static final String POOL_ELEMENTS_ARE_REUSED = PREFIX
			+ "Pool elements are reusable";

	public static final String POOL_ELEMENTS_ARE_DISPOSABLE = PREFIX
			+ "Pool elements are disposable";

	public static final String NUMBERS = PREFIX + "Numbers";

	public static final String OPERATORS = PREFIX + "Operators";

	public static final String NUMBERFIELD = PREFIX + "Numberfield";

	public static final String OPERATORFIELD = PREFIX + "Operatorfield";

	public static final String EXERCISE = PREFIX + "Exercise";

	public static final String UPDATE_VALUES = PREFIX + "Update values";

	public static final String FILL_EQUATION = PREFIX + "Fill Equation";

	public static final String SETTINGS = PREFIX + "Settings";

	public static final String EXERCISES = PREFIX + "Exercises";

	public static final String AVAILABLE_OPERATORS = PREFIX
			+ "Available operators";

	public static final String RANDOMIZE_CALCULATIONS = PREFIX
			+ "RANDOMIZE_CALCULATIONS";

	// Timedlevel test

	public static final String TIMEDLEVELTEST = PREFIX + "Timedleveltest";

	public static final String DESC = PREFIX + "DESC";

	public static final String INFO = PREFIX + "TIMED_LEVEL_TEST_INFO";

	public static final String LEVEL_INFO = PREFIX + "LEVEL_INFO";

	public static final String DIVISION_NOTICE = PREFIX + "DIVISION_NOTICE";

	public static final String MOUSEOVER_LEFT = PREFIX + "MOUSEOVER_LEFT";

	public static final String MOUSEOVER_RIGHT = PREFIX + "MOUSEOVER_RIGHT";

	public static final String MOUSEOVER_DIVISION_LEFT = PREFIX
			+ "MOUSEOVER_DIVISION_LEFT";

	public static final String MOUSEOVER_DIVISION_RIGHT = PREFIX
			+ "MOUSEOVER_DIVISION_RIGHT";

	public static final String EXERCISE_LEVEL = PREFIX + "EXERCISE_LEVEL";

	public static final String EXERCISE_START = PREFIX + "EXERCISE_START";

	public static final String EXERCISE_TIME_END = PREFIX + "EXERCISE_TIME_END";

	public static final String EDIT_NUMBERS_ONLY = PREFIX + "EDIT_NUMBERS_ONLY";

	public static final String RESULTS_CORRECT = PREFIX + "RESULTS_CORRECT";

	public static final String RESULTS_LEVEL_UP = PREFIX + "RESULTS_LEVEL_UP";

	public static final String RESULTS_THRESHOLD = PREFIX + "RESULTS_THRESHOLD";

	public static final String RESULTS_TIME = PREFIX + "RESULTS_TIME";

	public static final String NO_LEVELS = PREFIX + "NO_LEVELS";

	public static final String LEVEL = PREFIX + "LEVEL";

	public static final String OPERATOR = PREFIX + "OPERATOR";

	public static final String VALUE_RANGE = PREFIX + "VALUE_RANGE";

	public static final String VALUE_RANGE_ERROR = PREFIX + "VALUE_RANGE_ERROR";

	public static final String NUMBER_OF_QUESTIONS = PREFIX
			+ "NUMBER_OF_QUESTIONS";

	public static final String THRESHOLD = PREFIX + "THRESHOLD";

	public static final String SWAP_SIDES = PREFIX + "SWAP_SIDES";

	public static final String MOUSEOVER_SWAP_SIDES = PREFIX
			+ "MOUSEOVER_SWAP_SIDES";

	public static final String SHOW_TIMER = PREFIX + "SHOW_TIMER";

	public static final String ONE_AT_A_TIME = PREFIX
			+ "SHOW_ONE_QUESTION_AT_A_TIME";

	public static final String QUESTIONS_ASKED_AND_ANSWERED = PREFIX
			+ "QUESTIONS_ASKED_AND_ANSWERED";

	public static final String TIME = PREFIX + "TIME";

	public static final String CORRECTNESS = PREFIX + "CORRECTNESS";

	// Timedlevel test end.

	/* * Rounding exercise constants * */

	public static final String ROUND = PREFIX + "ROUND";

	public static final String NEAREST = PREFIX + "TONEAREST";

	public static final String BYDRAGGING = PREFIX + "BYDRAGGING";

	public static final String MIDDLENUMBER = PREFIX + "MIDDLENUMBER";

	public static final String DDQUESTION = PREFIX + "DDQUESTION";

	public static final String TYPING = PREFIX + "TYPING";

	public static final String CHOOSEPRECISION = PREFIX + "CHOOSEPRECISION";

	public static final String CORRECTANSWERIS = PREFIX + "CORRECTANSWERIS";

	public static final String ONE_ROUNDING_TARGET = PREFIX
			+ "ONE_ROUNDING_TARGET";

	public static final String THOUSANDTH = PREFIX + "THOUSANDTH";
	public static final String HUNDRETH = PREFIX + "HUNDRETH";
	public static final String TENTH = PREFIX + "TENTH";
	public static final String ONE = PREFIX + "ONE";
	public static final String TEN = PREFIX + "TEN";
	public static final String HUNDRED = PREFIX + "HUNDRED";
	public static final String THOUSAND = PREFIX + "THOUSAND";
	public static final String TENTHOUSAND = PREFIX + "TENTHOUSAND";

	public static final String EXERCISE_SETTINGS = "EXERCISE_SETTINGS";

	public static final String RANGE = PREFIX + "RANGE";

	public static final String MATH_MIN_AND_MAX = PREFIX + "MIN_AND_MAX";

	public static final String MATH_ANSWER_MIN_MAX = PREFIX + "ANSWER_MIN_MAX";

	public static final String EVEN_NUMBERS = PREFIX + "EVEN_NUMBERS";

	public static final String Separate_Term_Ranges = PREFIX
			+ "SEPARATE_TERM_RANGES";

	public static final String CHOOSE_LEVEL = PREFIX + "CHOOSE_LEVEL";

	public static final String MATH_INTERACTIVE = PREFIX + "MATH_INTERACTIVE";

	public static final String QUANTITY = PREFIX + "QUANTITY";

	public static final String TASK_TYPE = PREFIX + "TASK_TYPE";

	public static final String PRECISION = PREFIX + "PRECISION";

	public static final String RANGE_FOR_TERMS = PREFIX + "Ranges for terms";

	public static final String OR_ADD_CALCUATIONS_MANUALLY = "Or add calculations manually, one calcualtion on each line. For example 1+2";

	public static final String ADD_NEW_LEVEL = "Add new level";

	public static final String ERROR_PARSING_CALCULATION = "Error parsing calculation";

	public static final String SOLVE_QUADRATIC_EQUATIONS = "Solve quadratic equations.";

	public static final String EASY_CUBIC_EQUATIONS = "Solve easy cubic equations.";

	public static final String CARDGAME_AMOUNT_OF_CARDS = "Amount of Cards";

	public static final String MATH_GEOMETRY_HELP = "MATH_GEOM_HELP";

	public static final String SUBMIT_QUESTION = PREFIX + "Submit answers?";

	public static final String SUBMIT_QUESTION_DESCR = PREFIX
			+ "You can submit answers later yourself by pressing Submit -button";

	public static final String IS_MATH = PREFIX + "Is math";

	public static final String MATH_WRITE_ANSWER_TO_HOLE = PREFIX
			+ "Write answer in to the answer field";

	public static final String ALLOW_PARENTHESIS = PREFIX+"GENERATOR_ALLOW_PARENTHESIS";

	public static final String FORCE_PARENTHESIS = PREFIX+"GENERATOR_FORCE_PARENTHESIS";

	public static final String PARENTHESIS = PREFIX+"PARENTHESIS";

	public static final String NUMBEROFTERMS = "NUMBEROFTERMS";

}
